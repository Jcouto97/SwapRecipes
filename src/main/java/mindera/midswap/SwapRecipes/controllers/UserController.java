package mindera.midswap.SwapRecipes.controllers;


import lombok.RequiredArgsConstructor;
import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/vi/user")
public class UserController {

    private IUserService iUserService; //interface


    @GetMapping
    public UserDto getUserById(@PathVariable("id") Long id) {
        return this.iUserService.findById(id);
    }
}
