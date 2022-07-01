package mindera.midswap.SwapRecipes.services;


import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.commands.RecipeUpdateDto;
import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;

import java.util.List;

public interface RecipeServiceI {

    List<RecipeDto> getRecipes();

    RecipeDto getRecipeDtoById(Long id);

    Recipe getRecipeById(Long id);

    RecipeDto addRecipe(RecipeDto recipeDto);

    void removeRecipe(Long id);


List<Recipe> getRecipesByIngredient(Long ingredientId);


    UserDto saveFavouriteRecipe(Long userId, Long recipeId);

    RecipeDto addCategoryToRecipe(Long categoryId, Long recipeId);

    List<RecipeDto> getRecipesByCategory(String category);

    RecipeDto updateRecipe(Long recipeId, RecipeUpdateDto recipeUpdate);
}
