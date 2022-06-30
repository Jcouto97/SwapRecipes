package mindera.midswap.SwapRecipes.controllers;

import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.commands.UserUpdateDto;
import mindera.midswap.SwapRecipes.services.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserServiceI userServiceI;

    @Autowired
    public UserController(UserServiceI userServiceI) {
        this.userServiceI = userServiceI;
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") Long id) {
        return this.userServiceI.findById(id);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return this.userServiceI.getAllUsers();
    }

    @PostMapping
    public UserDto addUser(@Valid @RequestBody UserDto userDto) {
        return this.userServiceI.addUser(userDto);
    }

    @PutMapping("{id}")
    public UserDto updateUser(@PathVariable("id") Long id, @Valid @RequestBody UserUpdateDto userUpdateDto){
        return this.userServiceI.updateUser(id, userUpdateDto);
    }

    @PutMapping("/addrecipe/{userId}")//                       id user que quer receita      userNovo, id receita
    public UserDto saveFavouriteRecipe(@PathVariable("userId") Long userId, @RequestBody UserUpdateDto newUpdateDto){
        return this.userServiceI.saveFavouriteRecipe(userId, newUpdateDto);
    }
}
