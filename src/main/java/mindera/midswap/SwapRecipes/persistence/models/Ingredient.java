package mindera.midswap.SwapRecipes.persistence.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.nio.file.LinkOption;
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
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;


 //  @JsonIgnore
 //  @ManyToMany(mappedBy = "ingredientsIds",
 //          fetch = FetchType.LAZY,
 //          cascade = CascadeType.DETACH)
 //   private Set<Recipe> recipes;

    //PERSIST em vez de ALL, porque com PERSIST impede que a brand seja apagada se pelo menos um vehículo a esitver a usar


}
