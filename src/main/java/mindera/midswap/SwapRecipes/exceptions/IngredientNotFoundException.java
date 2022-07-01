package mindera.midswap.SwapRecipes.exceptions;


public class IngredientNotFoundException extends RuntimeException {
    public IngredientNotFoundException(String message){
        super(message);
    }
}
