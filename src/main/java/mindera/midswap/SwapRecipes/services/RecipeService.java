package mindera.midswap.SwapRecipes.services;



import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.converters.RecipeConverterI;
import mindera.midswap.SwapRecipes.converters.UserConverterI;
import mindera.midswap.SwapRecipes.exceptions.RecipeNotFoundException;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.persistence.repositories.RecipeJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService implements RecipeServiceI {

    private final RecipeConverterI recipeConverterI;
    private final RecipeJPARepository recipeRepository;
    private final UserServiceI userServiceI;


    @Override
    public List<RecipeDto> getRecipes() {
        return this.recipeConverterI.entityListToDtoList(this.recipeRepository.findAll());
    }

    @Override
    public RecipeDto getRecipeById(Long id) {
        Recipe recipe = this.recipeRepository.findById(id).orElseThrow(RecipeNotFoundException::new);
        return this.recipeConverterI.entityToDto(recipe);
    }

    @Override
    public RecipeDto addRecipe(RecipeDto recipeDto) {
        Recipe recipe = recipeConverterI.dtoToEntity(recipeDto);

      recipe.addIngredients(recipeDto.getIngredients());

        return this.recipeConverterI.entityToDto(this.recipeRepository.save(recipe));

    }

    @Override
    public void removeRecipe(Long id) {
        RecipeDto recipeToRemove = getRecipeById(id);
        this.recipeRepository.delete(this.recipeConverterI.dtoToEntity(recipeToRemove));
    }


   @Override
    public List<Recipe> getRecipesByIngredient(String ingredient) {
       return this.recipeRepository.findByIngredient(ingredient);
   }

    @Override
    public UserDto saveFavouriteRecipe(Long userId, Long recipeId) {
        Recipe recipe = recipeConverterI.dtoToEntity(getRecipeById(recipeId));
        return this.userServiceI.saveFavouriteRecipe(userId, recipe);
    }
}
