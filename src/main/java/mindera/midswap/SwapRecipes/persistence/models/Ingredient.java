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
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "extendedIngredients", //nome variável API externa
            fetch = FetchType.LAZY,
            cascade = CascadeType.DETACH)
    private Set<Recipe> recipesSet = new HashSet<>();

    private float amount;
    private String unit;


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


/*
1º guardamos chaves primarias e depois as secundarias


Fazer service + converter + interface + dto da api externa

DTO das receitas de fora

Metodo para guardar favorites?

Tabela para guardar favorites (ja temos), falta fazer as querys para ir buscar os favoritos


classe nova que so recebe lista de recipes(json) (lista de apirecipes) para receber os jsons atraves do rest template

qd fizermos deploy, como se tivessemos a iniciar

Bloqueio que o nuno fez para os ingredients temos que fazer para as recipes estoura se tivermos o update e dermos deploy 2x à app

getById por ingredient
queries se quisermos receitas por ingrediente
 */