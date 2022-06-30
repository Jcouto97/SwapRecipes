package mindera.midswap.SwapRecipes.services;



import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import mindera.midswap.SwapRecipes.converters.RecipeConverter;
import mindera.midswap.SwapRecipes.exceptions.RecipeNotFoundException;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.persistence.repositories.RecipeJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService implements RecipeServiceI {

    private final RecipeConverter recipeConverter;
    private final RecipeJPARepository recipeRepository;
    @Override
    public List<RecipeDto> getRecipes() {
        return this.recipeConverter.entityListToDtoList(this.recipeRepository.findAll());
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return this.recipeRepository.findById(id).orElseThrow(RecipeNotFoundException::new);
    }

    @Override
    public RecipeDto addRecipe(RecipeDto recipeDto) {
        Recipe saved = this.recipeRepository.save(this.recipeConverter.dtoToEntity(recipeDto));
        return this.recipeConverter.entityToDto(saved);
    }

    @Override
    public void removeRecipe(Long id) {
        this.recipeRepository.delete(getRecipeById(id));
    }


   @Override
    public List<Recipe> getRecipesByIngredient(String ingredient) {
       return this.recipeRepository.findByIngredient(ingredient);
   }
}
