package mindera.midswap.SwapRecipes.converters;

import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.IngredientDto;
import mindera.midswap.SwapRecipes.commands.IngredientUpdateDto;
import mindera.midswap.SwapRecipes.externalApi.byid.ApiIngredients;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class IngredientConverterImp implements IngrendientConverterI{

    private ModelMapper MODEL_MAPPER;

    @Override
    public IngredientDto entityToDto(Ingredient ingredient) {
        return this.MODEL_MAPPER.map(ingredient, IngredientDto.class);
    }

    @Override
    public Ingredient dtoToEntity(IngredientDto ingredientDto) {
        return this.MODEL_MAPPER.map(ingredientDto, Ingredient.class);
    }

    @Override
    public List<IngredientDto> entityListToDtoList(List<Ingredient> ingredients) {
        return ingredients.stream()
                .map(ingredient -> this.MODEL_MAPPER.map(ingredient, IngredientDto.class)).toList();
    }

    @Override
    public List<Ingredient> DtoListToEntityList(List<IngredientDto> ingredientDtos) {
        return null;
    }

    @Override
    public Ingredient updateDtoToEntity(IngredientUpdateDto ingredientUpdateDto, Ingredient ingredient) {
        this.MODEL_MAPPER.getConfiguration().setSkipNullEnabled(true);
        MODEL_MAPPER.map(ingredientUpdateDto, ingredient);
        return ingredient;
    }

    @Override
    public Set<Ingredient> apiEntityToEntity(Set<ApiIngredients> ingredients) {
        return ingredients.stream()
                .map(ingredient -> this.MODEL_MAPPER.map(ingredient, Ingredient.class)).collect(Collectors.toSet());
    }

    @Override
    public Ingredient apiEntityToEntity(ApiIngredients apiIngredient) {
        return this.MODEL_MAPPER.map(apiIngredient, Ingredient.class);
    }

}
