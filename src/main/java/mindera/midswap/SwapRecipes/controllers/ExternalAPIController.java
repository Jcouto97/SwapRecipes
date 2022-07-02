package mindera.midswap.SwapRecipes.controllers;

import lombok.RequiredArgsConstructor;
import mindera.midswap.SwapRecipes.externalApi.Results;
import mindera.midswap.SwapRecipes.externalApi.Type;
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
    //GET recipes
    //https://spoonacular.com/food-api/docs#Search-Recipes-Complex


    private final RecipeService recipeService;
    String uri = "https://api.spoonacular.com/";
    String apikey = "b028691f707a4dd48a1222aeef34bd81";

    //  https://api.spoonacular.com/recipes/complexSearch?query=pasta&maxFat=25&number=2&apiKey=b028691f707a4dd48a1222aeef34bd81 //auth

    @GetMapping(path = "/byrecipe/{ingredient}")
    public ResponseEntity<Type> getRecipeByIngredientName(@PathVariable String ingredient) {

        //https://api.spoonacular.com/recipes/complexSearch?query=pasta&apiKey=b028691f707a4dd48a1222aeef34bd81

        String finalUri = uri + "recipes/complexSearch?query=" + ingredient + "&apiKey=" + apikey;
        System.out.println("finalUri = " + finalUri);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Type> result = restTemplate.getForEntity(finalUri, Type.class);
        return ResponseEntity.ok(result.getBody());
        //resposta do JSON
        //https://api.spoonacular.com/recipes/complexSearch?query=pasta&apiKey=b028691f707a4dd48a1222aeef34bd81
    }




















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
