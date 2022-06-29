package mindera.midswap.SwapRecipes.services;

import mindera.midswap.SwapRecipes.persistence.models.Recipe;

import java.util.List;

public interface RecipeServiceI {

    List<Recipe> getRecipes();

    Recipe getRecipeById(Long id);

    List<Recipe> getRecipesByIngredient(String ingredient);
}
