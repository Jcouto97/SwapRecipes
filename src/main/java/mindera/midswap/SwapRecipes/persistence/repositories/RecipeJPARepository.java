package mindera.midswap.SwapRecipes.persistence.repositories;


import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeJPARepository extends JpaRepository<Recipe, Long> {
    //QUERIES PARA POSTMAN SÓ?

    //@Query("Select r FROM Recipe r JOIN r.extendedIngredients i WHERE i.id = ?1")
    //select * from ingredients i where i."name" like '%lime%'; QUERY IN POSTGRES
    //nome da tabela DB used_ingredients | IJ usedIngredient
    @Query("Select r FROM Recipe r JOIN r.extendedIngredients i WHERE i.name LIKE %?1%")
    List<Recipe> findByIngredientName(String ingredientName);

    Optional<Recipe> findById(Long id);

    Optional<Object> findByTitle(String name);

    //props da Recipe
    //@Query("Select r FROM Recipe r JOIN r.categoryIds i WHERE i.id = ?1") //devolve todas as receitas...
    //select * from recipe_category where category_id = 2; QUERY IN POSTGRES
    //nome da tabela DB recipe_category | IJ recipeCategory
    @Query("Select r FROM Recipe r JOIN r.categoryIds i WHERE i.id IN (?1)")//devolve todas as receitas...
    List<Recipe> findByCategory(Long category);
}
