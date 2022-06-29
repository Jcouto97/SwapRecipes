package mindera.midswap.SwapRecipes.converters;

import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import org.modelmapper.ModelMapper;

import java.util.List;

public class RecipeConverter implements DtoConvertersI <Recipe, RecipeDto> {

    public ModelMapper MODEL_MAPPER;

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
    public List<Recipe> DtoListToEntityList(List<RecipeDto> recipesDto) {
        return recipesDto.stream()
                .map(recipe -> MODEL_MAPPER.map(recipe, Recipe.class))
                .toList();
    }
}
