package mk.ukim.finki.emt.jewelryordermanagment.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.jewelryordermanagment.domain.valueobjects.JewelryProduct;
import mk.ukim.finki.emt.jewelryordermanagment.domain.valueobjects.UserId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "jewelry_orders")
@Getter
public class JewelryOrder extends AbstractEntity<OrderId> {

    private Instant orderOn;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @Column(name = "order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<JewelryItem> orderItemList = new HashSet<>();

    @AttributeOverride(name = "id", column = @Column(name = "user_id",
            nullable = false))
    private UserId userId;

    public JewelryOrder(Instant now, @NotNull Currency currency, UserId userId) {
        super(OrderId.randomId(OrderId.class));
        this.orderOn = now;
        this.currency = currency;
        this.userId = userId;
    }

    public static JewelryOrder build(Instant orderOn, OrderState orderState, Currency currency, Set<JewelryItem> orderItemList,
                                     UserId userId) {
        JewelryOrder order = new JewelryOrder();
        order.orderOn = orderOn;
        order.orderState = orderState;
        order.currency = currency;
        order.orderItemList = orderItemList;
        order.userId = userId;
        return order;
    }

    public JewelryOrder() {
        super(OrderId.randomId(OrderId.class));
    }

    public Money total() {
        return orderItemList.stream()
                .map(JewelryItem::subtotal)
                .reduce(new Money(currency, 0), Money::add);
    }

    public JewelryItem addItem(@NotNull JewelryProduct product, int qty) {
        Objects.requireNonNull(product, "product must not be null");
        var item = new JewelryItem(product.getId(), product.getMoney(), qty);
        orderItemList.add(item);
        return item;
    }

    public void removeItem(@NotNull JewelryItemId orderItemId) {
        Objects.requireNonNull(orderItemId, "Order Item must not be null");
        orderItemList.removeIf(v -> v.getId().equals(orderItemId));


    }

}
