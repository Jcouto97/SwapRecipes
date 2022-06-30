package mindera.midswap.SwapRecipes.dataloader;

import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.persistence.models.User;
import mindera.midswap.SwapRecipes.persistence.repositories.IngredientJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.RecipeJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.UserJPARepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private UserJPARepository userJPARepository;
    private IngredientJPARepository ingredientJPARepository;
    private RecipeJPARepository recipeRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        //lista Users
        List<User> userList = new ArrayList<>(Arrays.asList(
                User.builder().name("Elisa")
                        .idNumber(10001L)
                        .username("elisamoutinho")
                        .password("elisamoutinho")
                        .build(),
                User.builder().name("Ala")
                        .idNumber(10002L)
                        .username("alakropa")
                        .password("alakropa")
                        .build(),
                User.builder().name("Joao")
                        .idNumber(10003L)
                        .username("joaocouto")
                        .password("joaocouto")
                        .build()
        ));
        this.userJPARepository.saveAll(userList);

        //lista Ingredients
        List<Ingredient> ingredientList = new ArrayList<>(Arrays.asList(
                Ingredient.builder().name("Banana").build(),
                Ingredient.builder().name("Egg").build(),
                Ingredient.builder().name("Carrot").build(),
                Ingredient.builder().name("Pepper").build(),
                Ingredient.builder().name("Milk").build(),
                Ingredient.builder().name("Chocolate").build(),
                Ingredient.builder().name("Sugar").build(),
                Ingredient.builder().name("Water").build()
        ));
        this.ingredientJPARepository.saveAll(ingredientList);

        List<Recipe> recipeList = new ArrayList<>(Arrays.asList(
                Recipe.builder().name("Pizza")
                        .build(),
                Recipe.builder().name("Tea")
                        .build(),
                Recipe.builder().name("Cappuccino")
                        .build()
        ));
        this.recipeRepository.saveAll(recipeList);
    }
}
