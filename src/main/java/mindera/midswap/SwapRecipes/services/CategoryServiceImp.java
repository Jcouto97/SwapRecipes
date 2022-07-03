package mindera.midswap.SwapRecipes.services;


import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.CategoryDto;
import mindera.midswap.SwapRecipes.commands.CategoryUpdateDto;
import mindera.midswap.SwapRecipes.converters.CategoryConverterI;
import mindera.midswap.SwapRecipes.exceptions.CategoryAlreadyExistsException;
import mindera.midswap.SwapRecipes.exceptions.CategoryNotFoundException;
import mindera.midswap.SwapRecipes.exceptions.UserNotFoundException;
import mindera.midswap.SwapRecipes.persistence.models.Category;
import mindera.midswap.SwapRecipes.persistence.repositories.CategoryJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static mindera.midswap.SwapRecipes.exceptions.exceptionMessages.ExceptionMessages.*;

@AllArgsConstructor
@Service
public class CategoryServiceImp implements CategoryServiceI{

    private CategoryJPARepository categoryJPARepository;
    private CategoryConverterI categoryConverterI;

    @Override
    public List<CategoryDto> getCategoriesList() {
        List<Category> categoriesList = this.categoryJPARepository.findAll();
        if (categoriesList.isEmpty()) {
            throw new UserNotFoundException(CATEGORY_NOT_FOUND);
        }
        return this.categoryConverterI.entityListToDtoList(categoriesList);
    }

    @Override
    public CategoryDto getCategoryDtoById(Long id) {
        Category savedCategory = this.categoryJPARepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(CATEGORY_NOT_FOUND));
        return this.categoryConverterI.entityToDto(savedCategory);
    }

    @Override
    public Category getCategoryById(Long id) {
      return this.categoryJPARepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(CATEGORY_NOT_FOUND));
    }
    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        if(this.categoryJPARepository.findByName(categoryDto.getName()).isPresent()) {
            throw new CategoryAlreadyExistsException(CATEGORY_ALREADY_EXISTS);
        }
//        COMO SE APANHA RECURSO QUE JA EXISTE? (n atira exceçao como no mysql)

        Category categorySaved = this.categoryJPARepository.save(this.categoryConverterI.dtoToEntity(categoryDto));
        return this.categoryConverterI.entityToDto(categorySaved);
    }

    @Override
    public CategoryDto deleteCategory(Long id) {
        Category categoryToDelete = this.categoryJPARepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(CATEGORY_NOT_FOUND));
        this.categoryJPARepository.delete(categoryToDelete);
        return this.categoryConverterI.entityToDto(categoryToDelete);
    }



    @Override
    public CategoryDto updateCategory(Long id, CategoryUpdateDto categoryUpdateDtoDto) {
        Category categoryToDelete = this.categoryJPARepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(CATEGORY_NOT_FOUND));
        Category updatedCategory = this.categoryConverterI.updateDtoToEntity(categoryUpdateDtoDto, categoryToDelete);
        this.categoryJPARepository.save(updatedCategory);
        return this.categoryConverterI.entityToDto(updatedCategory);
    }
}
