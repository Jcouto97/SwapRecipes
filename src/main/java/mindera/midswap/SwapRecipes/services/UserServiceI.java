package mindera.midswap.SwapRecipes.services;


import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.commands.UserUpdateDto;

import java.util.List;

public interface UserServiceI {
    UserDto findById(Long id);
    List<UserDto> getAllUsers();
    UserDto addUser(UserDto userDto);
    UserDto updateUser(Long id, UserUpdateDto userUpdateDto);
    UserUpdateDto saveFavouriteRecipe(Long userId, Long recipeId);
    void deleteUserById(Long id);
}
