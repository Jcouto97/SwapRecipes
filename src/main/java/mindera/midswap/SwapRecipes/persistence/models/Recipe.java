package mindera.midswap.SwapRecipes.persistence.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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
//@EqualsAndHashCode
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "recipe_id", nullable = false, unique = true, updatable = false)
    private Long id;
    @Column(length = 5000)
    private String description;

    //private String name;
    private String title;
    private int readyInMinutes;
    private String sourceUrl;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private boolean dairyFree;
    private boolean cheap;
    //private List<Ingredient> extendedIngredients;
    //private String[] dishTypes;
    @Column(length = 5000)
    private String summary;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "favouriteRecipesIds",
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH)
    private Set<User> usersThatLiked = new HashSet<>();


    @JsonIgnore
    @Column(nullable = false, unique = false, updatable = true)
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "usedIngredients",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> extendedIngredients = new HashSet<>();
    //vai ter q ser mudado para extendedingredients
    //para usar o modelmappter tem q ter o mesmo nome q na api externa

    @JsonIgnore
    @Column(nullable = false, unique = false, updatable = true)
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "recipeCategory",                                 //nome da tabela que junta as duas
            joinColumns = @JoinColumn(name = "recipe_id"),              //nome das colunas da nova tabela
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categoryIds = new HashSet<>();



    public Set<Ingredient> getExtendedIngredients() {
        return extendedIngredients;
    }

    public void setExtendedIngredients(Set<Ingredient> extendedIngredients) {
        this.extendedIngredients = extendedIngredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public void addIngredients(Set<Ingredient> ingredientsIds) {
        this.extendedIngredients.addAll(ingredientsIds);
    }

    public void setCategoryIds(Set<Category> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public void addCategory(Category category) {
        this.categoryIds.add(category);
    }


}
