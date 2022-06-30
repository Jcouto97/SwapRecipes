package mindera.midswap.SwapRecipes.services;


import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.commands.UserUpdateDto;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;

import java.util.List;

public interface RecipeServiceI {

    List<RecipeDto> getRecipes();

    Recipe getRecipeById(Long id);

    RecipeDto addRecipe(RecipeDto recipeDto);

    void removeRecipe(Long id);

    List<Recipe> getRecipesByIngredient(String ingredient);

}
