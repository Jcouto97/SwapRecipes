package mindera.midswap.SwapRecipes.persistence.models;
import lombok.*;

import java.nio.file.LinkOption;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
//Entity
//Table
public class Ingredient {
    private Long id;

    private String name;

//    private List<Recipe> recipes;
}
