package mindera.midswap.SwapRecipes.controllers;


import lombok.RequiredArgsConstructor;
import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.services.RecipeServiceI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/recipes")
@RestController
public class RecipeController {

    public RecipeServiceI recipeService;

    @GetMapping
    public List<RecipeDto> getRecipies() {
        return this.recipeService.getRecipes();
    }

    //Not done yet
    // @GetMapping("/category/{category}")
    // public List<Recipe> getRecipesByCategory (@PathVariable("category") String category) {
    //     return this.recipeService.getRecipes();
    // }

    @GetMapping("/byId/{id}")
    public RecipeDto getRecipeById(@PathVariable("id") Long id) {
        return this.recipeService.getRecipeById(id);
    }


 //   @GetMapping("/ingredient/{ingredient}")
 //   public List<RecipeDto> getRecipesByIngredients(@PathVariable("ingredient") String ingredient) {
  //

}
