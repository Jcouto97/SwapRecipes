package mindera.midswap.SwapRecipes.converters;

import mindera.midswap.SwapRecipes.commands.IngredientDto;
import mindera.midswap.SwapRecipes.commands.IngredientUpdateDto;
import mindera.midswap.SwapRecipes.commands.UserUpdateDto;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.User;

public interface IngrendientConverterI extends ConverterI<Ingredient, IngredientDto>{

    Ingredient updateDtoToEntity(IngredientUpdateDto ingredientUpdateDto, Ingredient ingredient);
}
