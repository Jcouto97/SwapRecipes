package mindera.midswap.SwapRecipes.services;


import mindera.midswap.SwapRecipes.commands.UserDto;

import java.util.List;

public interface UserServiceI {
    UserDto findById(Long id);
    List<UserDto> getAllUsers();
    UserDto addUser(UserDto userDto);
}
