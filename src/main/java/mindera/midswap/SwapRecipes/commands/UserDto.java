package mindera.midswap.SwapRecipes.commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.*;


@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Name should have at least 2 characters!")
    @Pattern(regexp="^[a-zA-Z]*$",message = "Name should only contain letters!")
    private String name;

    @NotNull
    @Min(value = 10000, message = "identifcationNumber should start with 1 and be 6 characters long!")
    @Max(value = 99999, message = "identifcationNumber max number is 99,999!")
    private Long idNumber;

    @NotEmpty
    @Size(min = 2, message = "Username should have ate least 2 characters!")
    @Pattern(regexp="^[a-zA-Z]*$",message = "Username should only contain letters!")
    private String username;

    @NotEmpty
    @Size(min = 8, message = "Password should have at least 9 characters!")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    private Long favouriteRecipeId;

}
