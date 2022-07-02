package mindera.midswap.SwapRecipes.externalApi.byid;

import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor //precisa de final na prop
@Builder
@Getter
@Setter
public class ApiRecipeList {

    private List<ApiRecipe> recipes; //nome do postman

}
