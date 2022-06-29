package mindera.midswap.SwapRecipes.services;


import mindera.midswap.SwapRecipes.commands.UserDto;

public interface IUserService {
    UserDto findById(Long id);
}
