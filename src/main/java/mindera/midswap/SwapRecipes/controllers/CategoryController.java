package mindera.midswap.SwapRecipes.controllers;

import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.CategoryDto;
import mindera.midswap.SwapRecipes.commands.CategoryUpdateDto;
import mindera.midswap.SwapRecipes.services.CategoryServiceI;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/categories")
public class CategoryController {

    private final CategoryServiceI categoryServiceI;

    @GetMapping
    public List<CategoryDto> getCategoriesList(){
        return this.categoryServiceI.getCategoriesList();
    }

    @GetMapping(path = "/{id}")
    public CategoryDto getCategoryById(@PathVariable("id") Long id){
        return this.categoryServiceI.getCategoryDtoById(id);
    }

    @PostMapping
    public CategoryDto addCategory(@RequestBody CategoryDto categoryDto){
        return this.categoryServiceI.addCategory(categoryDto);
    }

    @DeleteMapping(path = "/{id}")
    public CategoryDto deleteCategory(@PathVariable("id") Long id){
        return this.categoryServiceI.deleteCategory(id);
    }

    @PutMapping(path = "/{id}")
    public CategoryDto updateCategory(@PathVariable("id") Long id, @RequestBody CategoryUpdateDto categoryUpdateDto){
        return this.categoryServiceI.updateCategory(id, categoryUpdateDto);
    }
}
