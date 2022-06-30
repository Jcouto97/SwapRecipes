package mindera.midswap.SwapRecipes.services;


import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.CategoryDto;
import mindera.midswap.SwapRecipes.commands.CategoryUpdateDto;
import mindera.midswap.SwapRecipes.converters.CategoryConverterI;
import mindera.midswap.SwapRecipes.exceptions.CategoryAlreadyExistsException;
import mindera.midswap.SwapRecipes.exceptions.CategoryNotFoundException;
import mindera.midswap.SwapRecipes.exceptions.IngredientAlreadyExistsException;
import mindera.midswap.SwapRecipes.exceptions.IngredientNotFoundException;
import mindera.midswap.SwapRecipes.persistence.models.Category;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.repositories.CategoryJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImp implements CategoryServiceI{

    private CategoryJPARepository categoryJPARepository;
    private CategoryConverterI categoryConverterI;

    @Override
    public List<CategoryDto> getCategoriesList() {
        return this.categoryConverterI.entityListToDtoList(this.categoryJPARepository.findAll());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category savedCategory = this.categoryJPARepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException());

        return this.categoryConverterI.entityToDto(savedCategory);
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        if(this.categoryJPARepository.findByName(categoryDto.getName()).isPresent()) {
            throw new CategoryAlreadyExistsException();
        }
//        COMO SE APANHA RECURSO QUE JA EXISTE? (n atira exceçao como no mysql)

        Category categorySaved = this.categoryJPARepository.save(this.categoryConverterI.dtoToEntity(categoryDto));



        return this.categoryConverterI.entityToDto(categorySaved);
    }

    @Override
    public CategoryDto deleteCategory(Long id) {
        Category categoryToDelete = this.categoryJPARepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException());


        this.categoryJPARepository.delete(categoryToDelete);

        return this.categoryConverterI.entityToDto(categoryToDelete);
    }



    @Override
    public CategoryDto updateCategory(Long id, CategoryUpdateDto categoryUpdateDtoDto) {
        Category categoryToDelete = this.categoryJPARepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException());
        Category updatedCategory = this.categoryConverterI.updateDtoToEntity(categoryUpdateDtoDto, categoryToDelete);
        this.categoryJPARepository.save(updatedCategory);

        return this.categoryConverterI.entityToDto(updatedCategory);
    }
}
