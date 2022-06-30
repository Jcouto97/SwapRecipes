package mindera.midswap.SwapRecipes.converters;

import mindera.midswap.SwapRecipes.commands.IngredientUpdateDto;
import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.commands.RecipeUpdateDto;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;

public interface RecipeConverterI extends ConverterI<Recipe, RecipeDto>{

    Recipe updateDtoToEntity(RecipeUpdateDto recipeUpdateDto, Recipe recipe);
}
