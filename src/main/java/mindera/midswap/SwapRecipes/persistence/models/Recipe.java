package mindera.midswap.SwapRecipes.persistence.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.ArrayList;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "favouriteRecipesIds",
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH)
    private List<User> usersThatLiked = new ArrayList<>();;



  @JsonIgnore
  @Column(nullable = false, unique = false, updatable = true)
   @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
   @JoinTable(name = "usedIngredients",
          joinColumns = @JoinColumn(name = "recipe_id"),
           inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
   private List<Ingredient> ingredientsIds = new ArrayList<>();

  private String description;



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

    public void addIngredients(List<Ingredient> ingredientsIds) {
        this.ingredientsIds.addAll(ingredientsIds);
    }
}
