package mindera.midswap.SwapRecipes.services;

import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.commands.UserUpdateDto;
import mindera.midswap.SwapRecipes.converters.UserConverterI;
import mindera.midswap.SwapRecipes.exceptions.UserAlreadyExistsException;
import mindera.midswap.SwapRecipes.exceptions.UserNotFoundException;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.persistence.models.User;
import mindera.midswap.SwapRecipes.persistence.repositories.UserJPARepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static mindera.midswap.SwapRecipes.exceptions.exceptionMessages.ExceptionMessages.USER_ALREADY_EXISTS;
import static mindera.midswap.SwapRecipes.exceptions.exceptionMessages.ExceptionMessages.USER_NOT_FOUND;


@Service
@AllArgsConstructor
public class UserServiceImpI implements UserServiceI, UserDetailsService {

    private UserJPARepository userJPARepository;
    private UserConverterI userConverterI;
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDto getUserById(Long id) {
        User user = this.userJPARepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        return this.userConverterI.entityToDto(user);

    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = this.userJPARepository.findAll();
        if (userList.isEmpty()) {
            throw new UserNotFoundException(USER_NOT_FOUND);
        }
        List<UserDto> dtoList = this.userConverterI.entityListToDtoList(userList);
        return dtoList;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        this.userJPARepository.findByCitizenNumber(userDto.getCitizenNumber()) //tenho que usar uma prop unique, e não o id
                .ifPresent((user) -> {
                    throw new UserAlreadyExistsException(USER_ALREADY_EXISTS);
                });
        User user = this.userConverterI.dtoToEntity(userDto);

        //set password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = this.userJPARepository.save(user);
        return this.userConverterI.entityToDto(savedUser);
    }

    @Override
    public UserDto updateUser(Long id, UserUpdateDto userUpdateDto) {
        // procuro o ID do "userUpdateDto" e guardo numa variável do tipo "User"
        User oldUser = this.userJPARepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        // "fromUserUpdateDtoToUser" passa tudo o que está no userUpdateDto para o oldUser
        User newUser = this.userConverterI.updateDtoToEntity(userUpdateDto, oldUser);

        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        // guardo na DB esse novo user
        User savedUser = this.userJPARepository.save(newUser);

        // converto para UserDto
        return this.userConverterI.entityToDto(savedUser);
    }

    @Override
    public UserDto saveFavouriteRecipe(Long userId, Recipe recipe) {
        User user = this.userJPARepository.findById(userId).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        user.addFavouriteRecipeId(recipe);
        this.userJPARepository.save(user);
        return this.userConverterI.entityToDto(user);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = this.userJPARepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        this.userJPARepository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userJPARepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", username))
                );
    }
}