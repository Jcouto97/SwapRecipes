package mindera.midswap.SwapRecipes;

import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.persistence.models.User;

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
