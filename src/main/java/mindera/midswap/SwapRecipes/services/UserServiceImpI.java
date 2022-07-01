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


@Service
@AllArgsConstructor
public class UserServiceImpI implements UserServiceI, UserDetailsService {

    private UserJPARepository userJPARepository;
    private UserConverterI userConverterI;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto findById(Long id) {
        User user = this.userJPARepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        UserDto userDto = this.userConverterI.entityToDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = this.userJPARepository.findAll();
        if (userList.isEmpty()) {
            throw new UserNotFoundException();
        }
        List<UserDto> dtoList = this.userConverterI.entityListToDtoList(userList);
        return dtoList;
    }

    public UserDto getUserById(Long id) {
        User user = this.userJPARepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        return this.userConverterI.entityToDto(user);
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        //@JsonProperty(access = JsonProperty.Access.READ_ONLY) //não deixa repetir o id, mesmo que no postman usemos um id repetido
        //procurar sempre por uma propriedade única SEM SER O ID que é gerado automaticamente
        this.userJPARepository.findByCitizenNumber(userDto.getCitizenNumber()) //tenho que usar uma prop unique, e não o id
                .ifPresent((user) -> {
                    throw new UserAlreadyExistsException();
                });

        User user = this.userConverterI.dtoToEntity(userDto);

        //set password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = this.userJPARepository.save(user);
        //mandar o Dto do savedUser que gravei, para ir com Id no Postman
        UserDto savedUserDto = this.userConverterI.entityToDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto updateUser(Long id, UserUpdateDto userUpdateDto) {
        // procuro o ID do "userUpdateDto" e guardo numa variável do tipo "User"
        User oldUser = this.userJPARepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());

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
        User user = this.userJPARepository.findById(userId).orElseThrow();
        user.addFavouriteRecipeId(recipe);
        this.userJPARepository.save(user);
        return this.userConverterI.entityToDto(user);
    }




    @Override
    public void deleteUserById(Long id) {
        User user = this.userJPARepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        this.userJPARepository.delete(user);
        //return this.userConverterI.entityToDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userJPARepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", username))
                );
    }
}