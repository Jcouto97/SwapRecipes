package mindera.midswap.SwapRecipes.exceptions;

public class RecipeNotFoundException extends RuntimeException{
    public RecipeNotFoundException(String message){
        super(message);
    }
}
