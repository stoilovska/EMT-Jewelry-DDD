package mk.ukim.finki.emt.jewelryordermanagment.service.forms;

import lombok.Data;
import lombok.NonNull;
import mk.ukim.finki.emt.jewelryordermanagment.domain.valueobjects.JewelryProduct;
import mk.ukim.finki.emt.jewelryordermanagment.domain.valueobjects.UserId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderItemForm {

    @NotNull
    private JewelryProduct product;

    @NotNull
    private UserId userId;

    @NotNull
    private Money money;

    @Min(1)
    private int quantity = 1;

    public OrderItemForm() {
    }
}


