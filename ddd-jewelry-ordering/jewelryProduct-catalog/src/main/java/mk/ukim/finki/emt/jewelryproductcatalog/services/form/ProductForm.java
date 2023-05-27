package mk.ukim.finki.emt.jewelryproductcatalog.services.form;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Data
public class ProductForm {
    private String jewelryName;
    private String manufacturer;
    private String category;
    private Money money;
    private int sales;
}
