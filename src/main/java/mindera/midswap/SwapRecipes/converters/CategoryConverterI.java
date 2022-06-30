package mindera.midswap.SwapRecipes.converters;

import mindera.midswap.SwapRecipes.commands.CategoryDto;
import mindera.midswap.SwapRecipes.commands.CategoryUpdateDto;
import mindera.midswap.SwapRecipes.commands.IngredientUpdateDto;
import mindera.midswap.SwapRecipes.persistence.models.Category;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;

public interface CategoryConverterI extends ConverterI<Category, CategoryDto> {

    Category updateDtoToEntity(CategoryUpdateDto categoryUpdateDto, Category category);
}
