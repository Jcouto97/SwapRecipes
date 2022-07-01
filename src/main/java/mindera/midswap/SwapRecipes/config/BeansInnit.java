package mindera.midswap.SwapRecipes.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.persistence.models.User;
import mindera.midswap.SwapRecipes.services.RecipeService;
import mindera.midswap.SwapRecipes.services.UserServiceImpI;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Configuration
public class BeansInnit {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    //quero que este Bean corra quando um User adiciona receitas

    @Bean
    CommandLineRunner runnerUser(UserServiceImpI userServiceImpI) { //chama mesmo a classe
        return args -> {
            //read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
            try {
                List<User> users = mapper.readValue(inputStream, typeReference);
                userServiceImpI.save(users);
                System.out.println("Users saved!");
            } catch (IOException e) {
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }
    @Bean
    CommandLineRunner runnerRecipe(RecipeService recipeService) { //chama mesmo a classe
        return args -> {
            //read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Recipe>> typeReference = new TypeReference<List<Recipe>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/recipes.json");
            try {
                List<Recipe> recipes = mapper.readValue(inputStream, typeReference);
                recipeService.save(recipes);
                System.out.println("Recipes saved!");
            } catch (IOException e) {
                System.out.println("Unable to save recupes: " + e.getMessage());
            }
        };
    }






//for single user
//    @Bean
//    CommandLineRunner runner(UserServiceImpI userService) {
//        return args -> {
//            //read json and write to db
//            ObjectMapper mapper = new ObjectMapper();
//            TypeReference<User> typeReference = new TypeReference<User>(){};
//            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
//            try {
//                User user = mapper.readValue(inputStream, typeReference);
//                userService.saveSingleUser(user);
//                System.out.println("User saved!");
//            }
//            catch (IOException e) {
//                System.out.println("Unable to save user: " + e.getMessage());
//            }
//
//        };
//    }


}
