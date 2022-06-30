package mindera.midswap.SwapRecipes.converters;

import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.IngredientUpdateDto;
import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.commands.RecipeUpdateDto;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class RecipeConverterImp implements RecipeConverterI {

    private final ModelMapper MODEL_MAPPER;

    @Override
    public RecipeDto entityToDto(Recipe recipe) {
        return MODEL_MAPPER.map(recipe, RecipeDto.class);
    }

    @Override
    public Recipe dtoToEntity(RecipeDto recipeDto) {
        return MODEL_MAPPER.map(recipeDto, Recipe.class);
    }

    @Override
    public List<RecipeDto> entityListToDtoList(List<Recipe> recipes) {
        return recipes.stream()
                .map(recipe -> MODEL_MAPPER.map(recipe, RecipeDto.class))
                .toList();
    }

    @Override
    public List<Recipe> DtoListToEntityList(List<RecipeDto> recipeDtos) {
        return recipeDtos.stream()
                .map(recipeDto -> MODEL_MAPPER.map(recipeDto, Recipe.class))
                .toList();
    }

    @Override
    public Recipe updateDtoToEntity(RecipeUpdateDto recipeUpdateDto, Recipe recipe) {
        this.MODEL_MAPPER.getConfiguration().setSkipNullEnabled(true);
        MODEL_MAPPER.map(recipeUpdateDto, recipe);
        return recipe;
    }
}
