package mindera.midswap.SwapRecipes.persistence.models;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(nullable = false, unique = false, updatable = true)
    private String name;

    @Column(nullable = false, unique = false, updatable = true)
    private String username;
    private String password;
    private Long favouriteRecipes;

}
