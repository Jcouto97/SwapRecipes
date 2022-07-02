package mindera.midswap.SwapRecipes.aspects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import mindera.midswap.SwapRecipes.persistence.models.User;
import mindera.midswap.SwapRecipes.services.UserServiceImpI;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Aspect
@Component
public class LoggingAspect {
    //AOP aspect oriented programming

    //private UserServiceImpI userServiceImpI;


    //mindera/midswap/SwapRecipes/services/RecipeService.java
//    @After("execution(* mindera/midswap/SwapRecipes/services/RecipeService.saveFavouriteRecipe(..))")
//    public CommandLineRunner runnerUser(UserServiceImpI userServiceImpI){ //chama mesmo a classe
//            return args -> {
//                //read json and write to db
//                ObjectMapper mapper = new ObjectMapper();
//                TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
//                };
//                InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
//                try {
//                    List<User> users = mapper.readValue(inputStream, typeReference);
//                    userServiceImpI.save(users);
//                    System.out.println("Users saved!");
//                } catch (IOException e) {
//                    System.out.println("Unable to save users: " + e.getMessage());
//                }
//            };
//        }



//    //mindera/midswap/SwapRecipes/services/RecipeService.java
//    @After("execution(* com.example.APIfromScratch.controllers.PersonController.addPerson(..))")
//    public void afterUserSavingFavouriteRecipe() {
//        //save da lista JSON so depois de se adicionar uma receita
//        System.out.println("afterUserSavingFavouriteRecipe()");
//    }

}
