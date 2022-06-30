package mindera.midswap.SwapRecipes.commands;

import lombok.*;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;

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
public class RecipeDto {

    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Name should have at least 2 characters!")
    private String name;

    private String description;

   private Set<Ingredient> ingredients;

}
