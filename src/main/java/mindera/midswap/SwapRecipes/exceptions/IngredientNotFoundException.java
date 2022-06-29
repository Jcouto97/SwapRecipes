package mindera.midswap.SwapRecipes.exceptions;


public class IngredientNotFoundException extends RuntimeException {
    public IngredientNotFoundException(){
        super("Ingredient not found");
    }
}
