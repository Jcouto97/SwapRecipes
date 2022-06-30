package mindera.midswap.SwapRecipes.persistence.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(nullable = false, unique = false, updatable = true)
    private String name;

    //@Column(nullable = false, unique = true, updatable = false)
    @Column(nullable = false, unique = false, updatable = true)
    private Long citizenNumber;

    @Column(nullable = false, unique = false, updatable = true)
    private String username;

    @Column(nullable = false, unique = false, updatable = true)
    private String password;

    @JsonIgnore
    @Column(nullable = false, unique = false, updatable = true)
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "favouriteRecipes",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "recipeId"))
    private List<Recipe> favouriteRecipesIds = new ArrayList<>();



    public void addFavouriteRecipeId(Recipe recipe) {
        this.favouriteRecipesIds.add(recipe);
      //  return this;
    }

    public void addFavouriteRecipeList(List<Recipe> recipeList){
        this.favouriteRecipesIds.addAll(recipeList);
    }
}
