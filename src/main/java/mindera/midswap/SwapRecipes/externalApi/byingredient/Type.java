package mindera.midswap.SwapRecipes.externalApi.byingredient;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public class Type {
    private List<Results> results; //nome tem q ser igual à prop que vem no JSON


    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
