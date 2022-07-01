//package mindera.midswap.SwapRecipes.externalApi;
//import mindera.midswap.SwapRecipes.persistence.models.Recipe;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//@RequestMapping("/api/v1")
//
//public class AnotherExternalAPIController {
//
//    String API_KEY = "1";
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    //recriar : www.themealdb.com/api/json/v1/1/search.php?s=chicken
//    @RequestMapping("/{name}")
//    public Recipe getRecipe(@PathVariable("name") String name) {
////        RecipeSummary recipeSummary = restTemplate.getForObject("www.themealdb.com/api/json/v1/" + API_KEY +
////                "/search.php?s=" + name, RecipeSummary.class);
////        return new Recipe(name, recipeSummary.getStrMeal(), recipeSummary.getStrCategory());
//        return null;
//}
//
//// "strMeal": "Spicy Arrabiata Penne",
////         "strDrinkAlternate": null,
////         "strCategory": "Vegetarian",
//
//    // Move these classes to a separate file! Only here for demonstration purposes.
//    public static class RecipeSummary {
//        public String strMeal;
//        public String strCategory;
//
//    public RecipeSummary(String strMeal, String strCategory) {
//        this.strMeal = strMeal;
//        this.strCategory = strCategory;
//    }
//
//    public String getStrMeal() {
//        return strMeal;
//    }
//
//    public void setStrMeal(String strMeal) {
//        this.strMeal = strMeal;
//    }
//
//    public String getStrCategory() {
//        return strCategory;
//    }
//
//    public void setStrCategory(String strCategory) {
//        this.strCategory = strCategory;
//    }
//}
//}
