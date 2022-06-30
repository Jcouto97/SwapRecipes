package mindera.midswap.SwapRecipes.services;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import mindera.midswap.SwapRecipes.converters.RecipeConverter;
import mindera.midswap.SwapRecipes.exceptions.RecipeNotFoundException;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.persistence.repositories.IngredientJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.RecipeJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecipeService implements RecipeServiceI {

    private final RecipeConverter recipeConverter;
    private final RecipeJPARepository recipeRepository;

    private final IngredientJPARepository ingredientJPARepository;

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
        Recipe newRecipe = new Recipe();
        newRecipe.setId(recipeDto.getId());
        newRecipe.setDescription(recipeDto.getDescription());
        newRecipe.setName(recipeDto.getName());
        Set<Ingredient> ingredientSet = recipeDto.getIngredients();
        if(ingredientSet != null) {
            newRecipe.setIngredientsIds(recipeDto.getIngredients()
                    .stream()
                    .map(ing -> {
                        Ingredient ingredient = ing;
                        if (this.ingredientJPARepository.findById(ingredient.getId()).isPresent()) {
                            ingredient = this.ingredientJPARepository.findById(ingredient.getId())
                                    .orElseThrow();
                        }
                        ingredient.addRecipe(this.recipeConverter.dtoToEntity(recipeDto));
                        return ingredient;

                    })
                    .collect(Collectors.toSet()));
        }
        return this.recipeConverter.entityToDto(this.recipeRepository.save(newRecipe));
                }

        @Override
        public void removeRecipe (Long id){
            this.recipeRepository.delete(getRecipeById(id));
        }


        @Override
        public List<Recipe> getRecipesByIngredient (String ingredient){
            return this.recipeRepository.findByIngredient(ingredient);
        }
    }
