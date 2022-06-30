package mindera.midswap.SwapRecipes.persistence.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.HashSet;
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
    @Column(name= "recipe_id", nullable = false, unique = true, updatable = false)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "favouriteRecipesIds",
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH)
    private Set<User> usersThatLiked = new HashSet<User>();;



 // @JsonIgnore
  @Column(nullable = false, unique = false, updatable = true)
   @ManyToMany(cascade = CascadeType.DETACH)
   @JoinTable(name = "usedIngredients",
          joinColumns = @JoinColumn(name = "recipe_id"),
           inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
   private Set<Ingredient> ingredientsIds = new HashSet<>();

  private String description;

  //  private Long ingredientId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsersThatLiked() {
        return usersThatLiked;
    }

    public void setUsersThatLiked(Set<User> usersThatLiked) {
        this.usersThatLiked = usersThatLiked;
    }

    public Set<Ingredient> getIngredientsIds() {
        return ingredientsIds;
    }

    public void setIngredientsIds(Set<Ingredient> ingredientsIds) {
        this.ingredientsIds = ingredientsIds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
// @JsonIgnore
//    @ManyToMany(mappedBy = "recipe", fetch = FetchType.LAZY,
//            cascade = CascadeType.DETACH)
//private List<Ingredient> ingredientList;