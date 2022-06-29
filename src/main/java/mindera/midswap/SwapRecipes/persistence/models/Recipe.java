package mindera.midswap.SwapRecipes.persistence.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "favouriteRecipesIds", fetch = FetchType.LAZY,
            cascade = CascadeType.DETACH)
    private Set<User> usersThatLiked;

// @JsonIgnore
//    @ManyToMany(mappedBy = "recipe", fetch = FetchType.LAZY,
//            cascade = CascadeType.DETACH)
    //private List<Ingredient> ingredientList;

    private String description;

}
