package mindera.midswap.SwapRecipes.dataloader;

import lombok.AllArgsConstructor;
import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.persistence.models.Category;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.persistence.models.User;
import mindera.midswap.SwapRecipes.persistence.repositories.CategoryJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.IngredientJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.RecipeJPARepository;
import mindera.midswap.SwapRecipes.persistence.repositories.UserJPARepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.xml.catalog.CatalogException;
import java.util.*;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private UserJPARepository userJPARepository;
    private IngredientJPARepository ingredientJPARepository;
    private RecipeJPARepository recipeRepository;

    private CategoryJPARepository categoryJPARepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        //lista Users
        List<User> userList = new ArrayList<>(Arrays.asList(
                User.builder().name("Elisa")
                        .citizenNumber(100000001L)
                        .username("elisamoutinho")
                        .password("elisamoutinho")
                        .build(),
                User.builder().name("Ala")
                        .citizenNumber(100000002L)
                        .username("alakropa")
                        .password("alakropa")
                        .build(),
                User.builder().name("Joao")
                        .citizenNumber(100000003L)
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
                Recipe.builder()
                        .name("Pizza")
                        .build(),
                Recipe.builder()
                        .name("Tea")
                        .build(),
                Recipe.builder()
                        .name("Cappuccino")
                        .build(),
                Recipe.builder()
                        .name("Feijoada")
                        .build(),
                Recipe.builder()
                        .name("Hamburger")
                        .build(),
                Recipe.builder()
                        .name("Pizza")
                        .build(),
                Recipe.builder()
                        .name("Piri-piri chicken")
                        .build(),
                Recipe.builder()
                        .name("Hummus")
                        .build()
        ));
        this.recipeRepository.saveAll(recipeList);

        List<Category> categoryList = new ArrayList<>(Arrays.asList(
                Category.builder()
                        .name("HotDrinks")
                        .build(),
                Category.builder()
                        .name("Desserts")
                        .build(),
                Category.builder()
                        .name("Breakfasts")
                        .build(),
                Category.builder()
                        .name("MainDishes")
                        .build(),
                Category.builder()
                        .name("Starters")
                        .build(),
               Category.builder()
                        .name("Vegetarian")
                        .build(),
                Category.builder()
                        .name("Vegan")
                        .build(),
                Category.builder()
                        .name("GlutenFree")
                        .build()
        ));
        this.categoryJPARepository.saveAll(categoryList);
    }
}
