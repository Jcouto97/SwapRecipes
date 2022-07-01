package mindera.midswap.SwapRecipes.services;


import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.IngredientDto;
import mindera.midswap.SwapRecipes.commands.IngredientUpdateDto;
import mindera.midswap.SwapRecipes.converters.IngredientConverterImp;
import mindera.midswap.SwapRecipes.converters.IngrendientConverterI;
import mindera.midswap.SwapRecipes.exceptions.IngredientAlreadyExistsException;
import mindera.midswap.SwapRecipes.exceptions.IngredientNotFoundException;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.repositories.IngredientJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static mindera.midswap.SwapRecipes.exceptions.exceptionMessages.ExceptionMessages.INGREDIENT_ALREADY_EXISTS;
import static mindera.midswap.SwapRecipes.exceptions.exceptionMessages.ExceptionMessages.INGREDIENT_NOT_FOUND;

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
    public IngredientDto getIngredientDtoById(Long ingredientId) {
        Ingredient savedIngredient = this.ingredientJPARepository.findById(ingredientId)
                .orElseThrow(() -> new IngredientNotFoundException(INGREDIENT_NOT_FOUND));
        return this.ingredientConverter.entityToDto(savedIngredient);
    }

    @Override
    public Ingredient getIngredientById(Long ingredientId) {
        return this.ingredientJPARepository.findById(ingredientId)
                .orElseThrow(() -> new IngredientNotFoundException(INGREDIENT_NOT_FOUND));
    }

    @Override
    public IngredientDto addIngredient(Ingredient ingredient) {
        if(this.ingredientJPARepository.findByName(ingredient.getName()).isPresent()) {
            throw new IngredientAlreadyExistsException(INGREDIENT_ALREADY_EXISTS);
        }
//        COMO SE APANHA RECURSO QUE JA EXISTE? (n atira exceçao como no mysql)

        Ingredient ingredientSaved = this.ingredientJPARepository.save(ingredient);
        return this.ingredientConverter.entityToDto(ingredientSaved);
    }

    @Override
    public IngredientDto deleteIngredient(Long id) {
        Ingredient ingredientToDelete = this.ingredientJPARepository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException(INGREDIENT_NOT_FOUND));
        this.ingredientJPARepository.delete(ingredientToDelete);
        return this.ingredientConverter.entityToDto(ingredientToDelete);
    }

    @Override
    public IngredientDto updateIngredient(Long id, IngredientUpdateDto ingredientUpdateDto) {
        Ingredient originalIngredient = this.ingredientJPARepository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException(INGREDIENT_NOT_FOUND));
        Ingredient updatedIngredient = this.ingredientConverter.updateDtoToEntity(ingredientUpdateDto, originalIngredient);
        this.ingredientJPARepository.save(updatedIngredient);
        return this.ingredientConverter.entityToDto(updatedIngredient);
    }

    @Override
    public boolean isIngredientPresent(Long id) {
        return this.ingredientJPARepository.findById(id).isPresent();
    }
}
