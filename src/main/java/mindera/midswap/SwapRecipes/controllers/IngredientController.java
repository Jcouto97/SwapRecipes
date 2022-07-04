package mindera.midswap.SwapRecipes.controllers;

import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.IngredientDto;
import mindera.midswap.SwapRecipes.commands.IngredientUpdateDto;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.services.IngredientServiceI;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/ingredients")
public class IngredientController {


    private final IngredientServiceI ingredientServiceI;

    @GetMapping
    @Cacheable(value = "ingredients")
    public List<IngredientDto> getIngredientsList(){
        System.out.println("getting ALL INGREDIENTS from DB");
        return this.ingredientServiceI.getIngredientsList();
    }
    @GetMapping("/evict/allingredients")
    @CacheEvict(value = "ingredients")
    public void evictAllIngredientsList() {
        System.out.println("Clearing getIngredientsList() cache");
    }




    @GetMapping(path = "/{IngredientId}")
    @Cacheable(value = "ingredients") //podemos definir tempo
    public IngredientDto getIngredientById(@PathVariable("IngredientId") Long ingredientId){
        System.out.println("getting GET INGREDIENTS BY ID from DB");
        return this.ingredientServiceI.getIngredientDtoById(ingredientId);
    }
    @GetMapping("/evict/ingredientsbyid/{ingredientId}")
    @CacheEvict(value = "ingredients")
    public void evictIngredientsIngredientById(@PathVariable("ingredientId") Long ingredientId) {
        System.out.println("Clearing getIngredientById() cache");
    }


    @Cacheable(value = "ingredients") //podemos definir tempo
    @GetMapping("/ingredientName/{ingredientName}")
    public List<IngredientDto> getIngredientByName(@PathVariable("ingredientName") String ingredientName) {
        System.out.println("getting GET INGREDIENTS BY NAME from DB");
        return this.ingredientServiceI.findByNameForQuery(ingredientName);
    }
    @GetMapping("/evict/ingredientsbyname/{ingredientName}")
    @CacheEvict(value = "ingredients")
    public void evictIngredientsIngredientByName(@PathVariable("ingredientName") String ingredientName) {
        System.out.println("Clearing getIngredientByName() cache");
    }




    @PostMapping
    public IngredientDto addIngredient(@RequestBody Ingredient ingredient){
        return this.ingredientServiceI.addIngredient(ingredient);
    }

    @DeleteMapping(path = "/{id}")
    public IngredientDto deleteIngredient(@PathVariable("id") Long id){
        return this.ingredientServiceI.deleteIngredient(id);
    }




    @PutMapping(path = "/{id}")
    public IngredientDto updateIngredient(@PathVariable("id") Long id, @RequestBody IngredientUpdateDto ingredientUpdateDto){
        return this.ingredientServiceI.updateIngredient(id, ingredientUpdateDto);
    }



}
