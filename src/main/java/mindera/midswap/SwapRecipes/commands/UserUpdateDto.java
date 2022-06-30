package mindera.midswap.SwapRecipes.commands;

import lombok.*;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserUpdateDto {

    @NotEmpty
    @Size(min = 2, message = "Name should have at least 2 characters!")
    @Pattern(regexp="^[a-zA-Z\s]*$",message = "Name should only contain letters!") //pode ter espaços
    private String name;

    @NotEmpty
    @Size(min = 2, message = "Username should have ate least 2 characters!")
    @Pattern(regexp="^[a-zA-Z]*$",message = "Username should only have letters!") //nao pode ter espaços
    private String username;

    private List<Recipe> favouriteRecipes;

}
