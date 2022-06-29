package mindera.midswap.SwapRecipes.converters;

import mindera.midswap.SwapRecipes.commands.IngredientDto;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import org.modelmapper.ModelMapper;

import java.util.List;

public class IngredientConverter implements DtoConvertersI<Ingredient, IngredientDto>{

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
}
