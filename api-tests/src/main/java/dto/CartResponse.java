package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CartResponse extends ResponseType{

    @JsonProperty("cart")
    List<Cart> cart;

    @JsonProperty("total_price")
    double totalPrice;

    @JsonProperty("total_discount")
    double totalDiscount;
}
