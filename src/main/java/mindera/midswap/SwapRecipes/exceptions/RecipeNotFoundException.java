package mindera.midswap.SwapRecipes.exceptions;

public class RecipeNotFoundException extends RuntimeException{
    public RecipeNotFoundException(){
        super("Recipe not found");
    }
}
