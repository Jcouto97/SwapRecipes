package mindera.midswap.SwapRecipes.persistence.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
//@EqualsAndHashCode
@Entity
@Table(name = "ingredients") //nome da tabela do postman
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;


    @JsonIgnore
    @ManyToMany(mappedBy = "ingredientsIds", //prop da classe que queremos juntar
            fetch = FetchType.LAZY,
            cascade = CascadeType.DETACH)
    private Set<Recipe> recipesSet = new HashSet<>();

    private String type;





    //PERSIST em vez de ALL, porque com PERSIST impede que a brand seja apagada se pelo menos um vehículo a esitver a usar


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

    public Set<Recipe> getRecipesSet() {
        return recipesSet;
    }

    public void setRecipesSet(Set<Recipe> recipesSet) {
        this.recipesSet = recipesSet;
    }

    public void addRecipe(Recipe recipeDto) {
        this.recipesSet.add(recipeDto);
    }
}
