package mindera.midswap.SwapRecipes.controllers;

import lombok.RequiredArgsConstructor;
import mindera.midswap.SwapRecipes.persistence.models.Ingredient;
import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import mindera.midswap.SwapRecipes.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ExternalAPIController {
    //String uri = "http://www.omdbapi.com/"; //localhost:8080/api/v1/mealbyid/52773
    //String apikey = "PUT_HERE_YOUR_API_KEY";

    private final RecipeService recipeService;
    String uri = "https://api.spoonacular.com/";
    String apikey = "b028691f707a4dd48a1222aeef34bd81";
//https://api.spoonacular.com/food/products/search?query=yogurt&apiKey=b028691f707a4dd48a1222aeef34bd81

    //  https://api.spoonacular.com/recipes/complexSearch?query=pasta&maxFat=25&number=2&apiKey=b028691f707a4dd48a1222aeef34bd81 //auth



    @GetMapping(path = "/byrecipe/{ingredient}")
    public ResponseEntity<Ingredient> getMeal(@PathVariable String ingredient) {
        //https://api.spoonacular.com/food/products/search?query=yogurt&apiKey=b028691f707a4dd48a1222aeef34bd81

        //https://api.spoonacular.com/recipes/complexSearch?query=pasta&apiKey=b028691f707a4dd48a1222aeef34bd81

        String finalUri = uri + "recipes/complexSearch?query=" + ingredient + "&apiKey=" + apikey;
        System.out.println("finalUri = " + finalUri);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Ingredient> result = restTemplate.getForEntity(finalUri, Ingredient.class);
        return ResponseEntity.ok(result.getBody());
    }

    //https://api.spoonacular.com/recipes/{id}/ingredientWidget.json

/*
*    private final RecipeService recipeService;
    String uri = "https://api.spoonacular.com/";
    String apikey = "b028691f707a4dd48a1222aeef34bd81";
//https://api.spoonacular.com/food/products/search?query=yogurt&apiKey=b028691f707a4dd48a1222aeef34bd81

    @GetMapping(path = "/ingredientsdb/{ingredient}")
    public ResponseEntity<Ingredient> getMeal(@PathVariable String ingredient) {
        //https://api.spoonacular.com/food/products/ search?query=yogurt&apiKey=b028691f707a4dd48a1222aeef34bd81
        String finalUri = uri + "food/products/search?query=" + ingredient + "&apiKey=" + apikey;
        System.out.println("finalUri = " + finalUri);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Ingredient> result = restTemplate.getForEntity(finalUri, Ingredient.class);
        return ResponseEntity.ok(result.getBody());
    }

    //https://api.spoonacular.com/recipes/{id}/ingredientWidget.json*/
//    @GetMapping(path = "recipe/{name}")
//    public ResponseEntity<Recipe> getRecipe(@PathVariable String name) {
//        String finalUri = uri + "?t=" + name + "&apikey=" + apikey;
//        System.out.println("finalUri = " + finalUri);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Recipe> result = restTemplate.getForEntity(finalUri, Recipe.class);
//        return ResponseEntity.ok(result.getBody());
//    }
//
//    @GetMapping(path = "recipe/{search}")
//    public ResponseEntity<FilmList> getFilms(@PathVariable String search) {
//        String finalUri = uri + "?s=" + search + "&apikey=" + apikey;
//        System.out.println("finalUri = " + finalUri);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<FilmList> result = restTemplate.getForEntity(finalUri, FilmList.class);
//        return ResponseEntity.ok(result.getBody());
//    }

    // Move these classes to a separate file! Only here for demonstration purposes.
    public static class Film {
        public String Title;
        public String Year;
        public String Poster;
        public String Type;


        @Override
        public String toString() {
            return "Film{" +
                    "Title='" + Title + '\'' +
                    ", Year='" + Year + '\'' +
                    '}';
        }
    }


    public static class FilmList {
        public Film[] Search;

        @Override
        public String toString() {
            return "FilmList{" +
                    "Search=" + Arrays.toString(Search) +
                    '}';
        }
    }

}
