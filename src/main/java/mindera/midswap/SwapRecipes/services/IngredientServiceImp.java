package mindera.midswap.SwapRecipes.services;


import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.IngredientDto;
import mindera.midswap.SwapRecipes.converters.IngredientConverterImp;
import mindera.midswap.SwapRecipes.converters.IngrendientConverterI;
import mindera.midswap.SwapRecipes.exceptions.IngredientAlreadyExistsException;
import mindera.midswap.SwapRecipes.exceptions.IngredientNotFoundException;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.repositories.IngredientJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IngredientServiceImp implements IngredientServiceI{

    private IngredientJPARepository ingredientJPARepository;
    private IngrendientConverterI ingredientConverter;

    @Override
    public List<IngredientDto> getIngredientsList() {
        return this.ingredientConverter.entityListToDtoList(this.ingredientJPARepository.findAll());
    }

    @Override
    public IngredientDto getIngredientById(Long ingredientId) {
        Ingredient savedIngredient = this.ingredientJPARepository.findById(ingredientId)
                .orElseThrow(() -> new IngredientNotFoundException());

        return this.ingredientConverter.entityToDto(savedIngredient);
    }

    @Override
    public IngredientDto addIngredient(Ingredient ingredient) {
        //exceçao se ja existir

//        if(this.ingredientJPARepository.findById(ingredient.getId()).isPresent()) {
//            throw new IngredientAlreadyExistsException();
//        }
//        COMO SE APANHA RECURSO QUE JA EXISTE? (n atira exceçao como no mysql)

        Ingredient ingredientSaved = this.ingredientJPARepository.save(ingredient);



        return this.ingredientConverter.entityToDto(ingredientSaved);
    }

    @Override
    public IngredientDto deleteIngredient(Long id) {
        Ingredient ingredientToDelete = this.ingredientJPARepository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException());

        this.ingredientJPARepository.delete(ingredientToDelete);

        return this.ingredientConverter.entityToDto(ingredientToDelete);
    }
}
