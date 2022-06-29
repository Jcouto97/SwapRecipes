package mindera.midswap.SwapRecipes.services;

import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.converters.DtoConvertersI;
import mindera.midswap.SwapRecipes.converters.UserConverter;
import mindera.midswap.SwapRecipes.exceptions.UserNotFoundException;
import mindera.midswap.SwapRecipes.persistence.models.User;
import mindera.midswap.SwapRecipes.persistence.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private IUserRepository iUserRepository;
    private UserConverter iUserConverter;

    @Autowired
    public UserService(IUserRepository iUserRepository, DtoConvertersI iUserConverter) {
        this.iUserRepository = iUserRepository;
        this.iUserRepository = iUserRepository;
    }

    @Override
    public UserDto findById(Long id) {
        User user = this.iUserRepository.findById(id)
                .orElseThrow( () -> new UserNotFoundException());



        UserDto userDto = this.iUserConverter.entityToDto(user);

        return userDto;
    }


}
