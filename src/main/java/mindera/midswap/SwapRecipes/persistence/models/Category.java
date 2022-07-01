package mindera.midswap.SwapRecipes.persistence.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "category_id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;


    @JsonIgnore
    @ManyToMany(mappedBy = "categoryIds",       //igual ao nome da lista de categories na Receita
            fetch = FetchType.LAZY,
            cascade = CascadeType.DETACH)
    private Set<Recipe> recipesSet = new HashSet<>();

    public Set<Recipe> getRecipesSet() {
        return recipesSet;
    }

    public void setRecipesSet(Set<Recipe> recipesSet) {
        this.recipesSet = recipesSet;
    }

    public void addRecipe(Recipe recipe) {
        this.recipesSet.add(recipe);
    }

//    @JsonIgnore
//    @ManyToMany(mappedBy = "recepiesIds",
//            fetch = FetchType.EAGER,
//            cascade = CascadeType.DETACH)
}
