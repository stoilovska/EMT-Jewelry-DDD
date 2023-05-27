package mk.ukim.finki.emt.jewelryordermanagment.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.validation.constraints.NotNull;

public class OrderId extends DomainObjectId {
    private OrderId() {
        super(OrderId.randomId(OrderId.class).getId());
    }

    public OrderId(@NotNull String uuid) {
        super(uuid);
    }

}
