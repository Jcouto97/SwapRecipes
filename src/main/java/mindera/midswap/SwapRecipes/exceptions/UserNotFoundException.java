package mindera.midswap.SwapRecipes.exceptions;


public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(){
        super("User not found");
    }
}
