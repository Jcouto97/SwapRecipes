package mindera.midswap.SwapRecipes.persistence.models;

import lombok.*;
import org.hibernate.annotations.Generated;

import javax.persistence.*;


@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    Long id;




}
