package mindera.midswap.SwapRecipes.persistence.repositories;


import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeJPARepository extends JpaRepository <Recipe, Long> {

    //@Query("FROM Recipe WHERE ingredientList LIKE %?1%")
    //List<Recipe> findByIngredient(String ingredient);
}
