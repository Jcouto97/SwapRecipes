package mindera.midswap.SwapRecipes.controllers;

import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.persistence.models.User;
import mindera.midswap.SwapRecipes.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/vi/user")
public class UserController {

    private IUserService iUserService; //interface

    @Autowired
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @GetMapping
    public UserDto getUserById(@PathVariable("id") Long id) {
        return this.iUserService.findById(id);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return this.iUserService.getAllUsers();
    }

    @PostMapping
    public UserDto addUser(@Valid @RequestBody UserDto userDto) {
        return this.iUserService.addUser(userDto);
    }
}
