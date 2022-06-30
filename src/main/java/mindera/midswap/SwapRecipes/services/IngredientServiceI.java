package mindera.midswap.SwapRecipes.services;


import mindera.midswap.SwapRecipes.commands.IngredientDto;
import mindera.midswap.SwapRecipes.commands.IngredientUpdateDto;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;

import java.util.List;

public interface IngredientServiceI {
    List<IngredientDto> getIngredientsList();

    IngredientDto getIngredientById(Long ingredientId);

    IngredientDto addIngredient(Ingredient ingredient);

    IngredientDto deleteIngredient(Long id);

    IngredientDto updateIngredient(Long id, IngredientUpdateDto ingredientUpdateDto);
}