package mindera.midswap.SwapRecipes.converters;

import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.CategoryDto;
import mindera.midswap.SwapRecipes.commands.CategoryUpdateDto;
import mindera.midswap.SwapRecipes.persistence.models.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class CategoryConverterImp implements CategoryConverterI{

    private final ModelMapper MODEL_MAPPER;

    @Override
    public CategoryDto entityToDto(Category category) {
        return this.MODEL_MAPPER.map(category, CategoryDto.class);
    }

    @Override
    public Category dtoToEntity(CategoryDto categoryDto) {
        return this.MODEL_MAPPER.map(categoryDto, Category.class);
    }

    @Override
    public List<CategoryDto> entityListToDtoList(List<Category> categories) {
        return categories.stream()
                .map(category -> this.MODEL_MAPPER.map(category, CategoryDto.class))
                .toList();
    }

    @Override
    public List<Category> DtoListToEntityList(List<CategoryDto> categoryDtos) {
        return null;
    }

    @Override
    public Category updateDtoToEntity(CategoryUpdateDto categoryUpdateDto, Category category) {
        this.MODEL_MAPPER.getConfiguration().setSkipNullEnabled(true);
        MODEL_MAPPER.map(categoryUpdateDto, category);
        return category;
    }
}
