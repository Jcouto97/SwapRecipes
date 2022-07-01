package mindera.midswap.SwapRecipes.unit.service;

import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.converters.RecipeConverterI;
import mindera.midswap.SwapRecipes.converters.UserConverterI;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.persistence.repositories.IngredientJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.RecipeJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.UserJPARepository;
import mindera.midswap.SwapRecipes.services.RecipeService;
import mindera.midswap.SwapRecipes.services.RecipeServiceI;
import mindera.midswap.SwapRecipes.services.UserServiceI;
import mindera.midswap.SwapRecipes.services.UserServiceImpI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static mindera.midswap.SwapRecipes.MockedPojos.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
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


    @BeforeEach
    public void setup() {
        this.recipeServiceI = new RecipeService(recipeConverterI, recipeJPARepository, ingredientJPARepository);
    }


//    @Test
//    void getRecipeTest(){
//        when(recipeJPARepository.save(RECIPE_ENTITY_1).
////                thenReturn(List.of(RECIPE_ENTITY_1);
//
//        // assert
//        assertEquals(2, recipeServiceI.getRecipes().size());
//    }
//

    @Test
    void getRecipesTest(){
        when(recipeJPARepository.findAll()).thenReturn(List.of(RECIPE_ENTITY_1, RECIPE_ENTITY_2));

        // assert
        assertEquals(2, recipeServiceI.getRecipes().size());
    }



    @Test
    void saveRecipeTest(){
        when(recipeJPARepository.save(RECIPE_ENTITY_1)).thenReturn(RECIPE_DTO_1);

        RecipeDto result = recipeServiceI.addRecipe(recipeConverterI.entityToDto(RECIPE_DTO_1));

        assertEquals(RECIPE_DTO_1, result);
    }

    @Test
    void testGetRecipeByIdSuccess() {
        // arrange
        when(recipeJPARepository.findById(1L))
                .thenReturn(Optional.of(RECIPE_ENTITY_1));

        // act
        RecipeDto result = recipeConverterI.entityToDto(recipeServiceI.getRecipeById(1L));

        // assert
        assertEquals(RECIPE_DTO_1, result);
    }
}


     /*
    adicionar receita
    procurar a receita (ela existe?)
    adiciono 2 ingredientes a receita tem tamanho 2?
    apago ingrediente que nao existe la, tem igual?
    ver se ela existe depois de dar delete
     */

