package mindera.midswap.SwapRecipes.services;


import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.UserDto;

import mindera.midswap.SwapRecipes.converters.UserConverter;
import mindera.midswap.SwapRecipes.exceptions.UserNotFoundException;
import mindera.midswap.SwapRecipes.persistence.models.User;
import mindera.midswap.SwapRecipes.persistence.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private IUserRepository iUserRepository;
    private UserConverter iUserConverter;



    @Override
    public UserDto findById(Long id) {
        User user = this.iUserRepository.findById(id)
                .orElseThrow( () -> new UserNotFoundException());



        //UserDto userDto = this.iUserConverter.entityToDto(user);

        return null;
    }
}
