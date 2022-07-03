package mindera.midswap.SwapRecipes.externalApi.byid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

//esta classe vai ter q ser a nossa classe Ingredients
//temos q fazer refactor da nossa classe Ingredients para receber estas props
@JsonIgnoreProperties
public class ApiIngredients {

    //como fazemos para aparecer o id da Api Externa?
    private Long id; //para aparecer o id do ingredient no postman
    private Long internalId; //para tirar
    private String name;
    private float amount;
    private String unit;
    //private Set<ApiRecipe> associatedRecipes; //aparece no postman


//    public Set<ApiRecipe> getAssociatedRecipes() {
//        return associatedRecipes;
//    }
//
//    public void setAssociatedRecipes(Set<ApiRecipe> associatedRecipes) {
//        this.associatedRecipes = associatedRecipes;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getInternalId() {
        return internalId;
    }

    public void setInternalId(Long internalId) {
        this.internalId = internalId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
