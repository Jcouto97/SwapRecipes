package mindera.midswap.SwapRecipes.persistence.repositories;


import mindera.midswap.SwapRecipes.commands.IngredientDto;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientJPARepository extends JpaRepository<Ingredient, Long> {

    public Optional<Ingredient> findById(Long id);
    Optional<Ingredient> findByName(String name);


    //@Query("Select r FROM Recipe r JOIN r.extendedIngredients i WHERE i.name LIKE %?1%")
    @Query("Select r FROM Ingredient r WHERE r.name LIKE %?1%")
    List<Ingredient> findByNameForQuery(String ingredientName);



   

    
}
