package mk.ukim.finki.emt.jewelryordermanagment.domain.model;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import mk.ukim.finki.emt.jewelryordermanagment.domain.valueobjects.JewelryId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Entity
@Table(name = "order_item")
@Getter
public class JewelryItem extends AbstractEntity<JewelryItemId> {

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="order_item_amount")),
            @AttributeOverride(name="currency", column = @Column(name="order_item_currency"))
    })
    private Money itemPrice;

    @Column(name = "qty", nullable = false)
    private int quantity;


    @AttributeOverride(name = "id", column = @Column(name = "product_id",
            nullable = false))
    private JewelryId productId;

    public JewelryItem(@NotNull JewelryId productId, @NotNull Money itemPrice, int qty) {
       super(DomainObjectId.randomId(JewelryItemId.class));
        this.productId = productId;
        this.itemPrice = itemPrice;
        this.quantity = qty;
    }

    public JewelryItem() {

    }

    public Money subtotal() {
        return itemPrice.multiply(quantity);
    }
}
