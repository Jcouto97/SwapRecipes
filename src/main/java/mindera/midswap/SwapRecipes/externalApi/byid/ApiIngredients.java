package mindera.midswap.SwapRecipes.externalApi.byid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//esta classe vai ter q ser a nossa classe Ingredients
//temos q fazer refactor da nossa classe Ingredients para receber estas props
@JsonIgnoreProperties
public class ApiIngredients {


     private String name;
     private float amount;
     private String unit;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
