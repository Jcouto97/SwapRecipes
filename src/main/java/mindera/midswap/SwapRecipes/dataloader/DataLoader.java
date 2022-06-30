package mindera.midswap.SwapRecipes.dataloader;

import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
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
public class DataLoader implements ApplicationRunner {

    private UserJPARepository userJPARepository;
    private IngredientJPARepository ingredientJPARepository;
    private RecipeJPARepository recipeJPARepository;

    public DataLoader(UserJPARepository userJPARepository,
                      IngredientJPARepository ingredientJPARepository,
                      RecipeJPARepository recipeJPARepository) {
        this.userJPARepository = userJPARepository;
        this.ingredientJPARepository = ingredientJPARepository;
        this.recipeJPARepository = recipeJPARepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //um User
//        User user1 = User.builder()
//                .name("Elisa")
//                .idNumber(10001L)
//                .username("elisamoutinho")
//                .password("elisamoutinho")
//                .build();
//        this.userJPARepository.save(user1);

        //um Ingredient
//        Ingredient ingredient1 = Ingredient.builder()
//                .name("banana")
//                .build();
//        this.ingredientJPARepository.save(ingredient1);

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
                Ingredient.builder().name("Ovo").build(),
                Ingredient.builder().name("Cenoura").build(),
                Ingredient.builder().name("Pimento").build()
        ));
        this.ingredientJPARepository.saveAll(ingredientList);
    }
}
