package mindera.midswap.SwapRecipes.commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import mindera.midswap.SwapRecipes.externalApi.byid.ApiIngredients;
import mindera.midswap.SwapRecipes.persistence.models.Category;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.persistence.models.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecipeDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private int readyInMinutes;
    private String sourceUrl;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private boolean dairyFree;
    private boolean cheap;
    private Set<ApiIngredients> extendedIngredients;
    //private String[] dishTypes;
    private String summary;


    @NotEmpty
    @Size(min = 2, max = 100, message = "Name should have at least 2 characters")
    private String title;     //tirar

//    private String description;   //tirar
//
//    private Set<Ingredient> ingredients;   //tirar

    private Set<Category> category;  //tabem para ligar nos dtos




  //  private Set<UserDto> usersThatLiked;
}
