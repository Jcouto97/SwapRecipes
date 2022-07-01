package mindera.midswap.SwapRecipes.services;


import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.RecipeUpdateDto;
import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.converters.RecipeConverterI;
import mindera.midswap.SwapRecipes.converters.UserConverterI;
import mindera.midswap.SwapRecipes.exceptions.CategoryNotFoundException;
import mindera.midswap.SwapRecipes.exceptions.RecipeAlreadyExistsException;
import mindera.midswap.SwapRecipes.exceptions.RecipeNotFoundException;
import mindera.midswap.SwapRecipes.persistence.models.Category;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.persistence.repositories.CategoryJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.IngredientJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.RecipeJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.UserJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static mindera.midswap.SwapRecipes.exceptions.exceptionMessages.ExceptionMessages.*;

@Service
@AllArgsConstructor
public class RecipeService implements RecipeServiceI {

    private final RecipeConverterI recipeConverterI;
    private final RecipeJPARepository recipeRepository;
    private final UserServiceI userServiceI;

    private final CategoryServiceI categoryServiceI;

    private final IngredientServiceI ingredientServiceI;
    private IngredientJPARepository ingredientJPARepository;

    private CategoryJPARepository categoryJPARepository;

    private UserConverterI userConverterI;


    @Override
    public List<RecipeDto> getRecipes() {
        return this.recipeConverterI.entityListToDtoList(this.recipeRepository.findAll());
    }

    @Override
    public RecipeDto getRecipeDtoById(Long id) {
        Recipe recipe = this.recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException(RECIPE_NOT_FOUND));
        return this.recipeConverterI.entityToDto(recipe);
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return this.recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException(RECIPE_NOT_FOUND));
    }

    @Override
    public RecipeDto addRecipe(RecipeDto recipeDto) {
        if (this.recipeRepository.findByName(recipeDto.getName()).isPresent()) {
            throw new RecipeAlreadyExistsException(RECIPE_ALREADY_EXISTS);
        }
        Recipe newRecipe = new Recipe();
        newRecipe.setId(recipeDto.getId());
        newRecipe.setDescription(recipeDto.getDescription());
        newRecipe.setName(recipeDto.getName());
        newRecipe.setCategoryIds(recipeDto.getCategory());
        Set<Ingredient> ingredientSet = recipeDto.getIngredients();
        if (ingredientSet != null) {
            newRecipe.setIngredientsIds(recipeDto.getIngredients()
                    .stream()
                    .map(ing -> {
                        Ingredient ingredient = ing;
                        if (this.ingredientJPARepository.findById(ingredient.getId()).isPresent()) {
                            ingredient = this.ingredientJPARepository.findById(ingredient.getId())
                                    .orElseThrow();
                        }
                        ingredient.addRecipe(this.recipeConverterI.dtoToEntity(recipeDto));
                        return ingredient;

                    })
                    .collect(Collectors.toSet()));
        }
        return this.recipeConverterI.entityToDto(this.recipeRepository.save(newRecipe));
    }

    @Override
    public void removeRecipe(Long id) {
        Recipe recipe = this.recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(RECIPE_NOT_FOUND));
        this.recipeRepository.delete(recipe);
    }


    @Override
    public List<Recipe> getRecipesByIngredient(Long ingredientId) {
        return this.recipeRepository.findByIngredient(ingredientId);
    }

    @Override
    public UserDto saveFavouriteRecipe(Long userId, Long recipeId) {
        Recipe recipe = getRecipeById(recipeId);
        return this.userServiceI.saveFavouriteRecipe(userId, recipe);
    }

    @Override
    public RecipeDto addCategoryToRecipe(Long categoryId, Long recipeId) {
        Recipe recipe = getRecipeById(recipeId);
        Category category = this.categoryServiceI.getCategoryById(categoryId);
        recipe.addCategory(category);
        this.recipeRepository.save(recipe);
        return recipeConverterI.entityToDto(recipe);
    }

    @Override
    public List<RecipeDto> getRecipesByCategory(String category) {
        return this.recipeRepository.findByCategory(category);
    }

    @Override
    public RecipeDto updateRecipe(Long recipeId, RecipeUpdateDto recipeUpdate) {
        Recipe recipeToBeUpdated = this.recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException(RECIPE_NOT_FOUND));
        Recipe updatedRecipe = this.recipeConverterI.updateDtoToEntity(recipeUpdate, recipeToBeUpdated);
        updatedRecipe.setCategoryIds(recipeUpdate.getCategory());
        updatedRecipe.setIngredientsIds(recipeUpdate.getIngredients());
        updatedRecipe.setUsersThatLiked(recipeUpdate.getUsersThatLiked()
                .stream()
                .map(userDto -> this.userConverterI.dtoToEntity(userDto))
                .collect(Collectors.toSet()));
        this.recipeRepository.save(updatedRecipe);
        return this.recipeConverterI.entityToDto(updatedRecipe);
    }
}
