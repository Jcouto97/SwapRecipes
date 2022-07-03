package mindera.midswap.SwapRecipes.controllers;

import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.IngredientDto;
import mindera.midswap.SwapRecipes.commands.IngredientUpdateDto;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.services.IngredientServiceI;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/ingredients")
public class IngredientController {


    private final IngredientServiceI ingredientServiceI;

    @GetMapping
    public List<IngredientDto> getIngredientsList(){
        return this.ingredientServiceI.getIngredientsList();
    }

    @GetMapping(path = "/{IngredientId}")
    public IngredientDto getIngredientById(@PathVariable("IngredientId") Long ingredientId){
        return this.ingredientServiceI.getIngredientDtoById(ingredientId);
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

    @GetMapping("/ingredientName/{ingredientName}")
    public List<IngredientDto> getIngredientByName(@PathVariable("ingredientName") String ingredientName) {
        return this.ingredientServiceI.findByNameForQuery(ingredientName);
    }

}
