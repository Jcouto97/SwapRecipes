package mindera.midswap.SwapRecipes.persistence.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public class Results {

    private List<ApiRecipe> results;
    private Long id;
    private String title;
    //            private int calories;
//            private String carbs;
//            private String fat;
    private String image;
    private String imageType;
//            private String protein;


    public List<ApiRecipe> getResults() {
        return results;
    }

    public void setResults(List<ApiRecipe> results) {
        this.results = results;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
}
