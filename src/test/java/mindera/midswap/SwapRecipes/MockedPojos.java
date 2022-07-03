package mindera.midswap.SwapRecipes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import mindera.midswap.SwapRecipes.commands.RecipeDto;
import mindera.midswap.SwapRecipes.commands.UserDto;
import mindera.midswap.SwapRecipes.persistence.models.Category;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.persistence.models.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.*;

public class MockedPojos {

    public static final User USER_ENTITY_1 = User.builder()
            .id(1L)
            .name("Elisa Moutinho")
            .citizenNumber(100000001L)
            .username("elisamoutinho")
            .password("elisamoutinho")
            .favouriteRecipesIds(new HashSet<>())
            .build();

    public static final UserDto USER_DTO_1 = UserDto.builder()
            .id(1L)
            .name("Elisa Moutinho")
            .citizenNumber(100000001L)
            .username("elisamoutinho")
            .password("elisamoutinho")
            .favouriteRecipes(new ArrayList<>())
            .build();

    public static final User USER_ENTITY_2 = User.builder()
            .id(2L)
            .name("Ala Kropa")
            .citizenNumber(100000002L)
            .username("alakropa")
            .password("alakropa")
            .favouriteRecipesIds(new HashSet<>())
            .build();

    public static final UserDto USER_DTO_2 = UserDto.builder()
            .id(2L)
            .name("Ala Kropa")
            .citizenNumber(100000002L)
            .username("alakropa")
            .password("alakropa")
            .favouriteRecipes(new ArrayList<>())
            .build();

    public static final Recipe RECIPE_ENTITY_1 = Recipe.builder()
            .id(1L)
            .title("bacalhau")
            .readyInMinutes(60)
            .sourceUrl("www.tugameals.com")
            .vegetarian(true)
            .vegan(false)
            .glutenFree(false)
            .dairyFree(false)
            .cheap(true)
            .summary("very nice")
            .usersThatLiked(new HashSet<>())
            .extendedIngredients(new HashSet<>())
            .categoryIds(new HashSet<>())
            .build();

    public static final RecipeDto RECIPE_DTO_1 = RecipeDto.builder()
            .id(1L)
            .title("bacalhau")
            .readyInMinutes(60)
            .sourceUrl("www.tugameals.com")
            .vegetarian(true)
            .vegan(false)
            .glutenFree(false)
            .dairyFree(false)
            .cheap(true)
            .summary("very nice")
            .extendedIngredients(new HashSet<>())
            .category(new HashSet<>())
            .build();

    public static final Recipe RECIPE_ENTITY_2 = Recipe.builder()
            .id(2L)
            .title("fried wings")
            .readyInMinutes(45)
            .sourceUrl("www.kfc.com")
            .vegetarian(false)
            .vegan(false)
            .glutenFree(false)
            .dairyFree(false)
            .cheap(true)
            .summary("very fat")
            .usersThatLiked(new HashSet<>())
            .extendedIngredients(new HashSet<>())
            .categoryIds(new HashSet<>())
            .build();

    public static final RecipeDto RECIPE_DTO_2 = RecipeDto.builder()
            .id(2L)
            .title("fried wings")
            .readyInMinutes(45)
            .sourceUrl("www.kfc.com")
            .vegetarian(false)
            .vegan(false)
            .glutenFree(false)
            .dairyFree(false)
            .cheap(true)
            .summary("very fat")
            .extendedIngredients(new HashSet<>())
            .category(new HashSet<>())
            .build();


    public static final UserDto USER_DTO_NO_PASS_1 = UserDto.builder()
            .id(1L)
            .name("Elisa Moutinho")
            .citizenNumber(100000001L)
            .username("elisamoutinho")
            .favouriteRecipes(new ArrayList<>())
            .build();


    //acceptance tests
    public static final UsernamePasswordAuthenticationToken AUTHENTICATION_1 = new UsernamePasswordAuthenticationToken(
            "rafael.miranda", null, new ArrayList<>());

    public static final Map<String, String> AUTH_HEADER = Map.of("Authorization", "Bearer jwtsomething");
}
