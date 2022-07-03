package mindera.midswap.SwapRecipes.service;

import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.converters.IngrendientConverterI;
import mindera.midswap.SwapRecipes.converters.RecipeConverterI;
import mindera.midswap.SwapRecipes.converters.UserConverterI;
import mindera.midswap.SwapRecipes.exceptions.RecipeNotFoundException;
import mindera.midswap.SwapRecipes.exceptions.UserNotFoundException;
import mindera.midswap.SwapRecipes.persistence.repositories.CategoryJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.IngredientJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.RecipeJPARepository;
import mindera.midswap.SwapRecipes.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static mindera.midswap.SwapRecipes.MockedPojos.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest {


    RecipeServiceI recipeServiceI;

    @Mock
    RecipeJPARepository recipeJPARepository;

    @Mock
    RecipeConverterI recipeConverterI;

    @Mock
    IngredientJPARepository ingredientJPARepository;

    @Mock
    UserServiceI userServiceI;

    @Mock
    CategoryServiceI categoryServiceI;

    @Mock
    IngrendientConverterI ingrendientConverterI;



    @BeforeEach
    public void setup() {
        this.recipeServiceI = new RecipeService(recipeConverterI, recipeJPARepository, userServiceI,
                categoryServiceI, ingredientJPARepository, ingrendientConverterI);
    }




    @Test
    void getRecipeSizeTest(){
        when(recipeJPARepository.findAll()).thenReturn(List.of(RECIPE_ENTITY_1, RECIPE_ENTITY_2));

        // assert
        assertEquals(2, recipeJPARepository.findAll().size());
    }



    @Test
    void saveRecipeTest(){

        when(recipeJPARepository.findByTitle(any())).thenReturn(Optional.ofNullable(RECIPE_ENTITY_1));

        when(recipeJPARepository.save(any())).thenReturn(RECIPE_ENTITY_1);

        RecipeDto result = recipeServiceI.addRecipe(RECIPE_DTO_1);
        //dto é o que o metodo recebe

        assertEquals(RECIPE_DTO_1, result);
    }

    @Test
    void testGetRecipeByIdSuccess() {
//        Expected :Recipe(id=1, title=bacalhau, readyInMinutes=60, sourceUrl=www.tugameals.com, vegetarian=true, vegan=false, glutenFree=false, dairyFree=false, cheap=true, summary=very nice, usersThatLiked=[], extendedIngredients=[], categoryIds=[])
//        Actual   :null

        // arrange
        when(recipeJPARepository.findById(any()))
                .thenReturn(Optional.of(RECIPE_ENTITY_1));

        // act
        RecipeDto result = recipeConverterI.entityToDto(recipeServiceI.getRecipeById(any()));

        // assert
        assertEquals(RECIPE_DTO_1, result);
    }

    @Test
    void testGetRecipeByIdNotFound() {   //PORQUE FUNCIONA?
        // arrange
        when(recipeJPARepository.findById(55L))
                .thenReturn(Optional.empty());

        // atc
        Executable action = () -> recipeServiceI.getRecipeById(55L);

        // assert
        assertThrows(RecipeNotFoundException.class, action);
    }
}


     /*
    adicionar receita
    procurar a receita (ela existe?)
    adiciono 2 ingredientes a receita tem tamanho 2?
    apago ingrediente que nao existe la, tem igual?
    ver se ela existe depois de dar delete
     */

