package mindera.midswap.SwapRecipes.persistence.models;


import lombok.*;

import javax.persistence.*;
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

    @Column(nullable = false, unique = false, updatable = true)
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "favouriteRecipes",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "recipeId"))
    private Set<Recipe> favouriteRecipesIds;




}
