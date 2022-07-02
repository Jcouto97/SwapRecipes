package mindera.midswap.SwapRecipes.commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
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


    @NotEmpty
    @Size(min = 2, max = 100, message = "Name should have at least 2 characters")
    private String name;

    private String description;

    private Set<Ingredient> ingredients;

    private Set<Category> category;  //tabem para ligar nos dtos




  //  private Set<UserDto> usersThatLiked;
}
