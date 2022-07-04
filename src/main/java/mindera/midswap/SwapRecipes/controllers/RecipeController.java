package mindera.midswap.SwapRecipes.controllers;


import lombok.RequiredArgsConstructor;
import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.commands.RecipeUpdateDto;
import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.services.RecipeServiceI;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("api/v1/recipes")
@RestController
public class RecipeController {

    private final RecipeServiceI recipeService;

    @GetMapping
    @Cacheable(value = "recipes")
    public List<RecipeDto> getRecipes() {
        System.out.println("getting ALL RECIPES from DB");
        return this.recipeService.getRecipes();
    }
    @GetMapping("/evict/allrecipes")
    @CacheEvict(value = "recipes")
    public void evictAllRecipes() {
        System.out.println("Clearing getAllRecipes() cache");
    }




    @Cacheable(value = "recipes")
    @GetMapping("/byId/{id}")
    public RecipeDto getRecipeById(@PathVariable("id") Long id) {
        System.out.println("getting RECIPE BY ID from DB");
        return this.recipeService.getRecipeDtoById(id);
    }
    @CacheEvict(value = "recipes")
    @GetMapping("/evict/recipebyid/{id}")
    public void evictGetRecipeById(@PathVariable("id") Long id) {
        System.out.println("Clearing getRecipeById() cache");
    }



    @Cacheable(value = "recipes")
    @GetMapping("/byCategoryId/{categoryId}")
    public List<RecipeDto> getRecipesByCategory(@PathVariable("categoryId") Long categoryId) {
        System.out.println("getting RECIPE BY CATEGORY from DB");
        return this.recipeService.findByCategory(categoryId);
    }
    @CacheEvict(value = "recipes")
    @GetMapping("/evict/recipebycategory/{id}")
    public void evictGetRecipesByCategory(@PathVariable("id") Long id) {
        System.out.println("Clearing getRecipeByCategory() cache");
    }




    @Cacheable(value = "recipes")
    @GetMapping("/byIngredientName/{ingredientName}")
    public List<RecipeDto> getRecipesByIngredientName(@PathVariable("ingredientName") String ingredientName) {
        System.out.println("getting RECIPE BY INGREDIENT NAME from DB");
        return this.recipeService.getRecipesByIngredientName(ingredientName);
    }
    @CacheEvict(value = "recipes")
    @GetMapping("/evict/recipebyingredientname/{ingredientName}")
    public void evictGetRecipesByIngredientName(@PathVariable("ingredientName") String ingredientName) {
        System.out.println("Clearing getRecipesByIngredientName() cache");
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

    @PutMapping("{ingredientId}/ingredient-recipe/{recipeId}")
    public RecipeDto addIngredientToRecipe(@PathVariable("ingredientId") Long ingredientId, @PathVariable("recipeId") Long recipeId) {
        RecipeDto updatedRecipe = this.recipeService.addIngredientToRecipe(ingredientId, recipeId);
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



