package mindera.midswap.SwapRecipes.services;


import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.commands.UserUpdateDto;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.persistence.models.User;

import java.util.List;

public interface UserServiceI {
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto addUser(UserDto userDto);
    UserDto updateUser(Long id, UserUpdateDto userUpdateDto);

    UserDto saveFavouriteRecipe(Long userId, Recipe recipe);

    void deleteUserById(Long id);

    //Iterable<User> list();

    User save(User user);

    Iterable<User> save(List<User> users);

    //Iterable<User> save(List<User> userList);
}
