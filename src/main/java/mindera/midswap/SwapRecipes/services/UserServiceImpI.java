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
    //private final BCryptPasswordEncoder bCryptPasswordEncoder;

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
        if(userList.isEmpty()) {
            throw new UserNotFoundException();
        }
        List<UserDto> dtoList = this.userConverterI.entityListToDtoList(userList);
        return dtoList;
    }

    public UserDto getUserByIdNumber(Long idNumber){
        User user = this.userJPARepository.findByIdNumber(idNumber)
                .orElseThrow( () -> new UserNotFoundException());
        return this.userConverterI.entityToDto(user);
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        this.userJPARepository.findByIdNumber(userDto.getCitizenNumber()) //tenho que usar uma prop unique, e não o id
                .ifPresent( (user) -> {
                    throw new UserAlreadyExistsException();
                });

        User user = this.userConverterI.dtoToEntity(userDto);

        //set password
        //user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        User savedUser = this.userJPARepository.save(user);
        //mandar o Dto do savedUser que gravei, para ir com Id no Postman
        UserDto savedUserDto = this.userConverterI.entityToDto(savedUser);
        return savedUserDto;
        }



}
