package mindera.midswap.SwapRecipes.services;


import lombok.RequiredArgsConstructor;
import mindera.midswap.SwapRecipes.converters.RecipeConverter;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.persistence.repositories.RecipeJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService implements RecipeServiceI {

    public RecipeJPARepository recipeRepository;
    public RecipeConverter recipeConverter;
    @Override
    public List<RecipeDto> getRecipes() {
        return this.recipeConverter.entityListToDtoList(this.recipeRepository.findAll());
    }

    @Override
    public RecipeDto getRecipeById(Long id) {
        return this.recipeConverter.entityToDto(this.recipeRepository.findById(id).orElseThrow());
    }

 //   @Override
//    public List<RecipeDto> getRecipesByIngredient(String ingredient) {
 //       return this.recipeRepository.findByIngredient(ingredient);
 //   }
}
