package mindera.midswap.SwapRecipes.externalApi.byid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
//para ir buscar do JSON
//como se fosse um DTO

@JsonIgnoreProperties
public class ApiRecipe {

    private String title;
    private int readyInMinutes;
    private String sourceUrl;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private boolean dairyFree;
    private boolean cheap;
    private Set<ApiIngredients> extendedIngredients;//n posso mudar o nome aqui
    //private String[] dishTypes;
    private String summary;



    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

//    public String[] getDishTypes() {
//        return dishTypes;
//    }
//
//    public void setDishTypes(String[] dishTypes) {
//        this.dishTypes = dishTypes;
//    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Set<ApiIngredients> getExtendedIngredients() {
        return extendedIngredients;
    }

    public void setExtendedIngredients(Set<ApiIngredients> extendedIngredients) {
        this.extendedIngredients = extendedIngredients;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public boolean isDairyFree() {
        return dairyFree;
    }

    public void setDairyFree(boolean dairyFree) {
        this.dairyFree = dairyFree;
    }


    public boolean isCheap() {
        return cheap;
    }

    public void setCheap(boolean cheap) {
        this.cheap = cheap;
    }

}
