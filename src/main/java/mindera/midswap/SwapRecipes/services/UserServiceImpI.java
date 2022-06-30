package mindera.midswap.SwapRecipes.services;
import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.converters.UserConverterI;
import mindera.midswap.SwapRecipes.exceptions.UserAlreadyExistsException;
import mindera.midswap.SwapRecipes.exceptions.UserNotFoundException;
import mindera.midswap.SwapRecipes.persistence.models.User;
import mindera.midswap.SwapRecipes.persistence.repositories.UserJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpI implements UserServiceI {

    private UserJPARepository userJPARepository;
    private UserConverterI userConverterI;


    @Override
    public UserDto findById(Long id) {
        User user = this.userJPARepository.findById(id)
                .orElseThrow( () -> new UserNotFoundException());
        UserDto userDto = this.userConverterI.entityToDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = this.userJPARepository.findAll();
        List<UserDto> dtoList = this.userConverterI.entityListToDtoList(userList);
        return dtoList;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
//        User user = this.iUserConverter.dtoToEntity(userDto);
        this.userJPARepository.findById(userDto.getId())
                .ifPresent( (user -> {
                    throw new UserAlreadyExistsException();
                }));
        return userDto;
        }

//        User user = this.iUserConverter.dtoToEntity(userDto);
//        this.iUserRepository.save(user);
//        return userDto;



}
