package mindera.midswap.SwapRecipes.commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import mindera.midswap.SwapRecipes.externalApi.byid.ApiRecipe;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IngredientDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    //nova prop unique dos Ingredients, que deverá mostrar o id interno (api externa) dos ApiIngredients
    //@Column(nullable = false, unique = true, updatable = false)
   // private Long internalId;

//    @NotEmpty
//    @Size(min = 2, max = 50, message = "Name should have at least 2 characters")
    private String name;

    //private Set<Recipe> recipeId; //será um set de ApiRecipe?
    //private Set<Recipe> recipeId; //será um set de ApiRecipe?

    //    private String title;
    private float amount;
    private String unit;
    //private String products;
}
