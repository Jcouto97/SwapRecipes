package mindera.midswap.SwapRecipes.controllers;


import lombok.RequiredArgsConstructor;
import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.commands.UserUpdateDto;
import mindera.midswap.SwapRecipes.converters.RecipeConverterI;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.persistence.models.User;
import mindera.midswap.SwapRecipes.persistence.repositories.IngredientJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.UserJPARepository;
import mindera.midswap.SwapRecipes.services.IngredientServiceI;
import mindera.midswap.SwapRecipes.services.RecipeServiceI;
import mindera.midswap.SwapRecipes.services.UserServiceI;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("api/v1/recipes")
@RestController
public class RecipeController {

    private final RecipeServiceI recipeService;

    @GetMapping
    public List<RecipeDto> getRecipes() {
        return this.recipeService.getRecipes();
    }


    @GetMapping("/byId/{id}")
    public RecipeDto getRecipeById(@PathVariable("id") Long id) {
        return this.recipeService.getRecipeById(id);
    }

    @PostMapping
    public RecipeDto addRecipe(@RequestBody RecipeDto recipeDto) {
        return this.recipeService.addRecipe(recipeDto);
    }

    @DeleteMapping("{id}")
    public void deleteRecipe(@PathVariable("id") Long id) {
        this.recipeService.removeRecipe(id);
    }

    @GetMapping("/byIngredient/{ingredientId}")
    public List<Recipe> getRecipesByIngredients(@PathVariable("ingredientId") Long ingredientId) {
        return this.recipeService.getRecipesByIngredient(ingredientId);

    }

    @PutMapping("/{userId}/{recipeId}")
    public UserDto addRecipeToFavourites(@PathVariable("userId") Long userId, @PathVariable("recipeId") Long recipeId) {
        //return this.userServiceI.saveFavouriteRecipe(userId, recipeId);
       return this.recipeService.saveFavouriteRecipe(userId, recipeId);
    }

    @PutMapping("/{categoryId}/{recipeId}")
    public RecipeDto addCategoryToRecipe(@PathVariable("categoryId") Long categoryId, @PathVariable("recipeId") Long recipeId) {
        return this.recipeService.addCategoryToRecipe(categoryId, recipeId);
    }

}

//Not done yet
// @GetMapping("/category/{category}")
// public List<Recipe> getRecipesByCategory (@PathVariable("category") String category) {
//     return this.recipeService.getRecipes();
// }


