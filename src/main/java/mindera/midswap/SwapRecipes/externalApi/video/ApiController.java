package mindera.midswap.SwapRecipes.externalApi.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    private RestTemplate restTemplate;

    private static String url = "https://restcountries.com/v3.1/all";

    //"https://www.themealdb.com/api/json/v1/1/categories.php"

    @GetMapping("/mealcategories")
    public List<Object> getMealCategories(){
        Object[] mealCategories = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(mealCategories);
    }
}
