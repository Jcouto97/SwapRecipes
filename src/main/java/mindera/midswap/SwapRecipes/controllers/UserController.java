package mindera.midswap.SwapRecipes.controllers;

import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.commands.UserUpdateDto;
import mindera.midswap.SwapRecipes.persistence.models.User;
import mindera.midswap.SwapRecipes.services.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(value = "users")
    public UserDto getUserById(@PathVariable("id") Long id) {
        System.out.println("getting USER BY ID from DB");
        return this.userServiceI.getUserById(id);
    }
    //When the above code block is run, any cached data with getUserById will be deleted from cache.
    @CacheEvict(value = "users")
    @GetMapping("/evict/userbyid/{id}")
    public void evictGetUserById(@PathVariable("id") Long id) {
        System.out.println("Clearing getUserById() cache");
    }


    @PutMapping("/{id}")
    @Cacheable(value = "users")
    public UserDto updateUser(@PathVariable("id") Long id, @Valid @RequestBody UserUpdateDto userUpdateDto){
        System.out.println("updating USER to DB");
        return this.userServiceI.updateUser(id, userUpdateDto);
    }
    @CacheEvict(value = "users") //este não percebo bem para que serve
    @GetMapping("/evict/updateuserbyid/{id}")
    public void evictupdateUser(@PathVariable("id")Long id) {
        System.out.println("Clearing updateUser() cache");
    }


    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Long id){
        System.out.println("deleting USER fom DB");
        /*return*/ this.userServiceI.deleteUserById(id);
    }
    //When the above code block is run, any cached data with deleteUser will be deleted from cache.
    @CacheEvict(value = "users") //este não percebo bem para que serve
    @GetMapping("/evict/deleteserbyid/{id}")
    public void evictDeleteUserById(@PathVariable("id")Long id) {
        System.out.println("Clearing deleteUser() cache");
    }


    @GetMapping
    @Cacheable(value = "users")
    public List<UserDto> getAllUsers() {
        System.out.println("getting ALL USERS from DB");
        return this.userServiceI.getAllUsers();
    }
    //When the above code block is run, any cached data with getAllUsers() will be deleted from cache.
    @CacheEvict(value = "users")
    @GetMapping("/evict/allusers")
    public void evictAllUsers() {
        System.out.println("Clearing getAllUsers() cache");
    }


    @PostMapping
    public UserDto addUser(@Valid @RequestBody UserDto userDto) {
        return this.userServiceI.addUser(userDto);
    }


    @GetMapping("/list")
    public Iterable<User> list() {
        return this.userServiceI.list();
    }

}
