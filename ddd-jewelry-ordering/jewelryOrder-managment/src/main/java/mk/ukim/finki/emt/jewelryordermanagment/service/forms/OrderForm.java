package mk.ukim.finki.emt.jewelryordermanagment.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.jewelryordermanagment.domain.valueobjects.UserId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderForm {

    @NotNull
    private Currency currency;

    @NotNull
    private UserId userId;

    @NotNull
    private Double amount;

    @Valid
    @NotEmpty
    private List<OrderItemForm> items = new ArrayList<>();
}
