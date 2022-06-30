package mindera.midswap.SwapRecipes.services;

import mindera.midswap.SwapRecipes.commands.CategoryDto;
import mindera.midswap.SwapRecipes.commands.CategoryUpdateDto;

import java.util.List;

public interface CategoryServiceI {
    List<CategoryDto> getCategoriesList();

    CategoryDto getCategoryById(Long id);

    CategoryDto addCategory(CategoryDto categoryDto);

    CategoryDto deleteCategory(Long id);

    CategoryDto updateCategory(Long id, CategoryUpdateDto categoryUpdateDto);
}
