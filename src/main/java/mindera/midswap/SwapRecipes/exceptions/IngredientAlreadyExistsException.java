package mindera.midswap.SwapRecipes.exceptions;

public class IngredientAlreadyExistsException extends RuntimeException{
    public IngredientAlreadyExistsException(){
        super("Ingredient already exists");
    }
}
