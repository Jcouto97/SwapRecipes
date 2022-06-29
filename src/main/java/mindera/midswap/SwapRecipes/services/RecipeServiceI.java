package mindera.midswap.SwapRecipes.services;

import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;

import java.util.List;

public interface RecipeServiceI {

    List<RecipeDto> getRecipes();

    RecipeDto getRecipeById(Long id);


//    List<RecipeDto> getRecipesByIngredient(String ingredient);
}
