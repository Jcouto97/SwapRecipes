package mindera.midswap.SwapRecipes.services;


import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.converters.DtoConvertersI;
import mindera.midswap.SwapRecipes.converters.UserConverter;
import mindera.midswap.SwapRecipes.exceptions.UserAlreadyExistsException;

import mindera.midswap.SwapRecipes.converters.UserConverter;
import mindera.midswap.SwapRecipes.exceptions.UserNotFoundException;
import mindera.midswap.SwapRecipes.persistence.models.User;
import mindera.midswap.SwapRecipes.persistence.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private IUserRepository iUserRepository;
    private UserConverter iUserConverter; //classe

    @Autowired
    public UserService(IUserRepository iUserRepository, UserConverter iUserConverter) {
        this.iUserRepository = iUserRepository;
        this.iUserConverter = iUserConverter;
    }

    @Override
    public UserDto findById(Long id) {
        User user = this.iUserRepository.findById(id)
                .orElseThrow( () -> new UserNotFoundException());
        UserDto userDto = this.iUserConverter.entityToDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = this.iUserRepository.findAll();
        List<UserDto> dtoList = this.iUserConverter.entityListToDtoList(userList);
        return dtoList;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
//        User user = this.iUserConverter.dtoToEntity(userDto);
        this.iUserRepository.findById(userDto.getId())
                .ifPresent( (user -> {
                    throw new UserAlreadyExistsException();
                }));
        }

//        User user = this.iUserConverter.dtoToEntity(userDto);
//        this.iUserRepository.save(user);
//        return userDto;
    }


}
