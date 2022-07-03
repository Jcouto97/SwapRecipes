package mindera.midswap.SwapRecipes.services;

import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.RecipeUpdateDto;
import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.converters.IngrendientConverterI;
import mindera.midswap.SwapRecipes.converters.RecipeConverterI;
import mindera.midswap.SwapRecipes.exceptions.RecipeAlreadyExistsException;
import mindera.midswap.SwapRecipes.exceptions.RecipeNotFoundException;
import mindera.midswap.SwapRecipes.persistence.models.Category;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.persistence.repositories.IngredientJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.RecipeJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static mindera.midswap.SwapRecipes.exceptions.exceptionMessages.ExceptionMessages.*;

@Service
@AllArgsConstructor
public class RecipeService implements RecipeServiceI {

    private final RecipeConverterI recipeConverterI;
    private final RecipeJPARepository recipeRepository;
    private final UserServiceI userServiceI;
    private final CategoryServiceI categoryServiceI;
    private IngredientJPARepository ingredientJPARepository;
    private IngrendientConverterI ingrendientConverterI;


    @Override
    public List<RecipeDto> getRecipes() {
        return this.recipeConverterI.entityListToDtoList(this.recipeRepository.findAll());
    }

    @Override
    public RecipeDto getRecipeDtoById(Long id) {
        Recipe recipe = this.recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException(RECIPE_NOT_FOUND));
        return this.recipeConverterI.entityToDto(recipe);
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return this.recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException(RECIPE_NOT_FOUND));
    }

    @Override
    public RecipeDto addRecipe(RecipeDto recipeDto) {
        if (this.recipeRepository.findByTitle(recipeDto.getTitle()).isPresent()) {
            throw new RecipeAlreadyExistsException(RECIPE_ALREADY_EXISTS);
        }
        Recipe newRecipe = new Recipe();
        newRecipe.setId(recipeDto.getId());
        newRecipe.setTitle(recipeDto.getTitle());
        newRecipe.setCategoryIds(recipeDto.getCategory());//ver se tendo isto aqui, posso nao ter no AddRecipe no Postman
        //alteracoes teste
        //newRecipe.setExtendedIngredients(this.ingrendientConverterI.apiEntityToEntity(recipeDto.getExtendedIngredients()));//api ing -> ing
        newRecipe.setReadyInMinutes(recipeDto.getReadyInMinutes());
        newRecipe.setSourceUrl(recipeDto.getSourceUrl());
        newRecipe.setSummary(recipeDto.getSummary());
        Set<Ingredient> ingredientSet = this.ingrendientConverterI.apiEntityToEntity(recipeDto.getExtendedIngredients());

//objetivo passar de apiIngredient -> Ingredient
        if (ingredientSet != null) {
            newRecipe.setExtendedIngredients(recipeDto.getExtendedIngredients()
                    .stream()
                    .map(ing -> {
                        Ingredient ingredient = this.ingrendientConverterI.apiEntityToEntity(ing);
                        if (this.ingredientJPARepository.findById(ingredient.getId()).isPresent()) {
                            ingredient = this.ingredientJPARepository.findById(ingredient.getId())
                                    .orElseThrow();
                        }
                        ingredient.addRecipe(this.recipeConverterI.dtoToEntity(recipeDto));
                        return ingredient;

                    })
                    .collect(Collectors.toSet()));
        }
        return this.recipeConverterI.entityToDto(this.recipeRepository.save(newRecipe));
    }

    @Override
    public void removeRecipe(Long id) {
        Recipe recipe = this.recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(RECIPE_NOT_FOUND));
        this.recipeRepository.delete(recipe);
    }


    @Override
    public List<RecipeDto> getRecipesByIngredientName(String ingredientName) {
        List<Recipe> recipes = this.recipeRepository.findByIngredientName(ingredientName);
        if(recipes.isEmpty()) {
            throw new RecipeNotFoundException(RECIPE_NOT_FOUND);
        }
        return this.recipeConverterI.entityListToDtoList(recipes);
    }

    @Override
    public List<RecipeDto> getVegetarianRecipes() {
        List<Recipe> recipes = this.recipeRepository.findVegetarianRecipes();
        if(recipes.isEmpty()) {
            throw new RecipeNotFoundException(RECIPE_NOT_FOUND);
        }
        return this.recipeConverterI.entityListToDtoList(recipes);
    }

    @Override
    public List<RecipeDto> getVeganRecipes() {
        List<Recipe> recipes = this.recipeRepository.findVeganRecipes();
        if(recipes.isEmpty()) {
            throw new RecipeNotFoundException(RECIPE_NOT_FOUND);
        }
        return this.recipeConverterI.entityListToDtoList(recipes);
    }

    @Override
    public List<RecipeDto> getGlutenFreeRecipes() {
        List<Recipe> recipes = this.recipeRepository.findGlutenFreeRecipes();
        if(recipes.isEmpty()) {
            throw new RecipeNotFoundException(RECIPE_NOT_FOUND);
        }
        return this.recipeConverterI.entityListToDtoList(recipes);
    }

    @Override
    public List<RecipeDto> getDairyFreeRecipes() {
        List<Recipe> recipes = this.recipeRepository.findDairyFreeRecipes();
        if(recipes.isEmpty()) {
            throw new RecipeNotFoundException(RECIPE_NOT_FOUND);
        }
        return this.recipeConverterI.entityListToDtoList(recipes);
    }

    @Override
    public UserDto saveFavouriteRecipe(Long userId, Long recipeId) {
        Recipe recipe = getRecipeById(recipeId);
        //if user of recipe doesnt exist, throw exception
        return this.userServiceI.saveFavouriteRecipe(userId, recipe);
    }

    @Override
    public RecipeDto addCategoryToRecipe(Long categoryId, Long recipeId) {
        Recipe recipe = getRecipeById(recipeId);
        Category category = this.categoryServiceI.getCategoryById(categoryId);
        recipe.addCategory(category);
        this.recipeRepository.save(recipe);
        return recipeConverterI.entityToDto(recipe);
    }

    @Override //RecipeServiceI "return value of the method is never used
    public List<RecipeDto> findByCategory(Long categoryId) {
        List<Recipe> recipes = this.recipeRepository.findByCategory(categoryId);
        if(recipes.isEmpty()) {
            throw new RecipeNotFoundException(CATEGORY_NOT_FOUND);
        }
        return this.recipeConverterI.entityListToDtoList(recipes);
    }

    @Override
    public RecipeDto updateRecipe(Long recipeId, RecipeUpdateDto recipeUpdate) {
        Recipe recipeToBeUpdated = this.recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException(RECIPE_NOT_FOUND));
        Recipe newRecipe = this.recipeConverterI.updateDtoToEntity(recipeUpdate, recipeToBeUpdated);

        newRecipe.setSourceUrl(newRecipe.getSourceUrl());
        newRecipe.setCategoryIds(newRecipe.getCategoryIds());
        newRecipe.setExtendedIngredients(newRecipe.getExtendedIngredients());
//        newRecipe.setCategoryIds(recipeUpdate.getCategory());
//        newRecipe.setExtendedIngredients(recipeUpdate.getIngredients());


        Recipe savedRecipe = this.recipeRepository.save(newRecipe);
        return this.recipeConverterI.entityToDto(savedRecipe);
    }


}
