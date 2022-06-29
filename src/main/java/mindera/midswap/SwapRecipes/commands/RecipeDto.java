package mindera.midswap.SwapRecipes.commands;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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

   private Long ingredientId;

}
