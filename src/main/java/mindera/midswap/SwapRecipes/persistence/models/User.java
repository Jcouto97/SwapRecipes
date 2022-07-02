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

    @Column(nullable = false, unique = true, updatable = false)
    private Long citizenNumber;

    @Column(nullable = false, unique = false, updatable = true)
    private String username;

    @Column(nullable = false, unique = false, updatable = true)
    private String password;

    @JsonIgnore
    @Column(nullable = false, unique = false, updatable = true)
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "favouritesRecipes",
            joinColumns = @JoinColumn(name = "user_Id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_Id"))
    private Set<Recipe> favouriteRecipesIds = new HashSet<>();









    public User addFavouriteRecipeId(Recipe recipe) {
        this.favouriteRecipesIds.add(recipe);
        return this;
    }

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

    public Long getCitizenNumber() {
        return citizenNumber;
    }

    public void setCitizenNumber(Long citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Recipe> getFavouriteRecipesIds() {
        return favouriteRecipesIds;
    }

    public void setFavouriteRecipesIds(Set<Recipe> favouriteRecipesIds) {
        this.favouriteRecipesIds = favouriteRecipesIds;
    }
}
