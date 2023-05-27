package mk.ukim.finki.emt.jewelryproductcatalog.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;

@Entity
@Table(name="jewelry_product")
@Getter
public class JewelryProduct extends AbstractEntity<JewelryId> {

    private String jewelryName;

    private String manufacturer;

    private String category;

    private int sales = 0;

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="product_amount")),
            @AttributeOverride(name="currency", column = @Column(name="product_currency"))
    })
    private Money money;

    protected JewelryProduct() {
        super(JewelryId.randomId(JewelryId.class));
    }
    public static JewelryProduct build(String productName, String manufacturer, String category, Money price, int sales) {
        JewelryProduct p = new JewelryProduct();
        p.manufacturer = manufacturer;
        p.category = category;
        p.money = price;
        p.jewelryName = productName;
        p.sales = sales;
        return p;
    }

    public void addSales(int qty) {
        this.sales = this.sales - qty;
    }

    public void removeSales(int qty) {
        this.sales -= qty;
    }
}
