package mindera.midswap.SwapRecipes.exceptions;

public class CategoryAlreadyExistsException extends RuntimeException{
    public CategoryAlreadyExistsException(){
        super("Category already exists");
    }
}
