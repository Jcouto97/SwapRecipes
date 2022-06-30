package mindera.midswap.SwapRecipes.persistence.repositories;


import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientJPARepository extends JpaRepository<Ingredient, Long> {

    public Optional<Ingredient> findById(Long id);

    Optional<Object> findByName(String name);
    //aseguir ao findBy -> é a propriedade que tenho no ingredient
}
