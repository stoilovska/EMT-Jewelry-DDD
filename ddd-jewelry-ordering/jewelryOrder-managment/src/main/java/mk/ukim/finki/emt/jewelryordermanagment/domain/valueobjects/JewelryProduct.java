package mk.ukim.finki.emt.jewelryordermanagment.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;


@Getter
public class JewelryProduct implements ValueObject {

    private final JewelryId id;
    private final String name;
    private final String manufacturer;
    private final String category;
    private final Money money;
    private final int sales;

    private JewelryProduct() {
        this.id= JewelryId.randomId(JewelryId.class);
        this.name= "";
        this.manufacturer = "";
        this.category = "";
        this.money = Money.valueOf(Currency.MKD,0);
        this.sales = 0;
    }

    @JsonCreator
    public JewelryProduct(@JsonProperty("id") JewelryId id,
                          @JsonProperty("jewelryName") String name,
                          @JsonProperty("manufacturer") String manufacturer,
                          @JsonProperty("category") String category,
                          @JsonProperty("money") Money price,
                          @JsonProperty("sales") int sales) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.category = category;
        this.money = price;
        this.sales = sales;
    }
}

