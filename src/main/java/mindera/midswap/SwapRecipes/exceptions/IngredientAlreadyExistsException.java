package mindera.midswap.SwapRecipes.exceptions;

public class IngredientAlreadyExistsException extends RuntimeException{
    public IngredientAlreadyExistsException(String message){
        super(message);
    }
}
