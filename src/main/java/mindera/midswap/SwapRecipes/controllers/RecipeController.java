package mindera.midswap.SwapRecipes.controllers;


import lombok.RequiredArgsConstructor;
import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.commands.RecipeUpdateDto;
import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.services.RecipeServiceI;
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
        return this.recipeService.getRecipeDtoById(id);
    }

    @GetMapping("/byCategoryId/{categoryId}")
    public List<RecipeDto> getRecipesByCategory(@PathVariable("categoryId") Long categoryId) {
        return this.recipeService.findByCategory(categoryId);
        //        this.recipeService.findByCategory(categoryId);
    }

    @GetMapping("/byIngredientName/{ingredientName}")
    public List<RecipeDto> getRecipesByIngredientName(@PathVariable("ingredientName") String ingredientName) {
        return this.recipeService.getRecipesByIngredientName(ingredientName);

    }
    @PostMapping
    public RecipeDto addRecipe(@RequestBody RecipeDto recipeDto) {
        return this.recipeService.addRecipe(recipeDto);
    }

    @PutMapping("/{userId}/user-recipe/{recipeId}")
    public UserDto addRecipeToFavourites(@PathVariable("userId") Long userId, @PathVariable("recipeId") Long recipeId) {
       return this.recipeService.saveFavouriteRecipe(userId, recipeId);
    }

    @PutMapping("/{categoryId}/category-recipe/{recipeId}")
    public RecipeDto addCategoryToRecipe(@PathVariable("categoryId") Long categoryId, @PathVariable("recipeId") Long recipeId) {
      RecipeDto updatedRecipe = this.recipeService.addCategoryToRecipe(categoryId, recipeId);
       return updatedRecipe;
    }

    @PutMapping("/{recipeId}")
    public RecipeDto updateRecipe(@PathVariable("recipeId") Long recipeId, @RequestBody RecipeUpdateDto recipeUpdate) {
        RecipeDto updatedRecipe = this.recipeService.updateRecipe(recipeId, recipeUpdate);
        return updatedRecipe;
    }

    @DeleteMapping("{id}")
    public void deleteRecipe(@PathVariable("id") Long id) {
        this.recipeService.removeRecipe(id);
    }

    @GetMapping("/vegetarian")
    public List<RecipeDto> getVegetarianRecipes(){
        return this.recipeService.getVegetarianRecipes();
    }

    @GetMapping("/vegan")
    public List<RecipeDto> getVeganRecipes(){
        return this.recipeService.getVeganRecipes();
    }

    @GetMapping("/glutenFree")
    public List<RecipeDto> getGlutenFreeRecipes(){
        return this.recipeService.getGlutenFreeRecipes();
    }

    @GetMapping("/dairyFree")
    public List<RecipeDto> getDairyFreeRecipes(){
        return this.recipeService.getDairyFreeRecipes();
    }



}



