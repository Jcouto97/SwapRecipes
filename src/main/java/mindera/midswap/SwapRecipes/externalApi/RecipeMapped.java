package mindera.midswap.SwapRecipes.externalApi;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RecipeMapped {

    public String strMeal;
    public String strCategory;


    @Override
    public String toString() {
        return "RecipeMapped{" +
                "strMeal='" + strMeal + '\'' +
                ", strCategory='" + strCategory + '\'' +
                '}';
    }
}
