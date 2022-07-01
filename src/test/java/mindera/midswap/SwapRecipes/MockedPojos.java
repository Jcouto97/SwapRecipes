package mindera.midswap.SwapRecipes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.persistence.models.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MockedPojos {

    public static final User USER_ENTITY_1 = User.builder()
            .name("Elisa")
            .id(1L)
            .citizenNumber(100000001L)
                        .username("elisamoutinho")
                        .password("elisamoutinho")
                        .build();

    public static final Recipe RECIPE_ENTITY_1 = Recipe.builder()
            .name("bacalhau")
            .id(1L)
            .description("very good")
            .usersThatLiked(new ArrayList<>())
            .ingredientsIds(new ArrayList<>())
            .build();

    public static final Recipe RECIPE_DTO_1 = Recipe.builder()
            .name("bacalhau")
            .id(1L)
            .description("very good")
            .ingredientsIds(new ArrayList<>())
            .build();

    public static final Recipe RECIPE_ENTITY_2 = Recipe.builder()
            .name("arroz")
            .id(2L)
            .description("very nice")
            .usersThatLiked(new ArrayList<>())
            .ingredientsIds(new ArrayList<>())
            .build();



//
//    private Long id;
//
//    private String name;
//
//    private List<User> usersThatLiked = new ArrayList<User>();;
//
//    private List<Ingredient> ingredientsIds = new ArrayList<>();
//
//    private String description;


//           .id(1L)
//            .name("Joaquim Almeida")
//            .citizenNumber(100000000L)
//            .username("joaquimalmeida")
//            .password("password")
//            .favouriteRecipesIds(Set.of(new Recipe(1L, "bacalhau", new ArrayList<>(3), new ArrayList<>(1) , "very good")))
//            .build();


    //    private Long id;
//
//    @Column(nullable = false, unique = false, updatable = true)
//    private String name;
//
//    @Column(nullable = false, unique = true, updatable = false)
//    private Long citizenNumber;
//
//    @Column(nullable = false, unique = false, updatable = true)
//    private String username;
//
//    @Column(nullable = false, unique = false, updatable = true)
//    private String password;
}
