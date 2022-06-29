package mindera.midswap.SwapRecipes.services;



import lombok.RequiredArgsConstructor;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.persistence.repositories.RecipeJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService implements RecipeServiceI {

    public RecipeJPARepository recipeRepository;
    @Override
    public List<Recipe> getRecipes() {
        return this.recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return this.recipeRepository.findById(id).orElseThrow();
    }

//    @Override
//    public List<Recipe> getRecipesByIngredient(String ingredient) {
//        return this.recipeRepository.findByIngredient(ingredient);
//    }
}
