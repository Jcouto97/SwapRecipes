package mindera.midswap.SwapRecipes.commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.util.List;


@ToString
@Builder
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) //não deixa repetir o id, mesmo que no postman usemos um id repetido
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Name should have at least 2 characters!")
    @Pattern(regexp="^[a-zA-Z\s]*$",message = "Name should only contain letters!") //pode conter espaços
    private String name;

    @NotNull
    @Min(value = 100000000, message = "Citizen Number should start with 1 and be 9 characters long!")
    @Max(value = 999999999, message = "Citizen Number max number is 999,999,999!")
    private Long citizenNumber;

    @NotEmpty
    @Size(min = 2, message = "Username should have ate least 2 characters!")
    @Pattern(regexp="^[a-zA-Z]*$",message = "Username should only contain letters!") //não pode conster espaços
    private String username;

    @NotEmpty
    @Size(min = 8, message = "Password should have at least 9 characters!")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    private List<Recipe> favouriteRecipes;

}
