package mindera.midswap.SwapRecipes.externalApi;

import mindera.midswap.SwapRecipes.persistence.models.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1")

public class ExternalAPIController {
    String uri = "https://www.themealdb.com/api/json/v1/";
    String apikey = "1";
    String search = "search.php";

    //recriar : www.themealdb.com/api/json/v1/1/search.php?s=chicken
    @GetMapping(path = "/desiredRecipe/{name}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable String name) {
        String finalUri = uri + apikey + search + "?s=" + name;
        System.out.println("finalUri = " + finalUri);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Recipe> result = restTemplate.getForEntity(finalUri, Recipe.class);
        return ResponseEntity.ok(result.getBody());
    }

    @GetMapping(path = "recipes/{search}")
    public ResponseEntity<FilmList> getRecipes(@PathVariable String search) {
        String finalUri = uri + "?s=" + search + "&apikey=" + apikey;
        System.out.println("finalUri = " + finalUri);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FilmList> result = restTemplate.getForEntity(finalUri, FilmList.class);
        return ResponseEntity.ok(result.getBody());
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

    /*

     */
}
