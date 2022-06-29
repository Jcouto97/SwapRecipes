package mindera.midswap.SwapRecipes.controllers;


import lombok.RequiredArgsConstructor;
import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.services.RecipeServiceI;
import org.springframework.http.ResponseEntity;
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
    public Recipe getRecipeById(@PathVariable("id") Long id) {
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

    @GetMapping("/ingredient/{ingredient}")
    public List<Recipe> getRecipesByIngredients(@PathVariable("ingredient") String ingredient) {
        return this.recipeService.getRecipesByIngredient(ingredient);

    }

}

//Not done yet
// @GetMapping("/category/{category}")
// public List<Recipe> getRecipesByCategory (@PathVariable("category") String category) {
//     return this.recipeService.getRecipes();
// }


