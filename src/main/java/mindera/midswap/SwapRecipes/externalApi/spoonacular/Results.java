package mindera.midswap.SwapRecipes.externalApi.spoonacular;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Results {
    private int id;
    private String title;
    private String image;
//    private String jpeg;

//    public Product(int id, String title, String image, String jpeg) {
//        this.id = id;
//        this.title = title;
//        this.image = image;
//        this.jpeg = jpeg;
//    }

    //406 not accepable ou
    // 500 Cannot construct instance of `mindera.midswap.SwapRecipes.externalApi.spoonacular.Type` (no Creators,
    // like default constructor, exist): cannot deserialize from Object value

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

//    public String getJpeg() {
//        return jpeg;
//    }
//
//    public void setJpeg(String jpeg) {
//        this.jpeg = jpeg;
//    }


}
