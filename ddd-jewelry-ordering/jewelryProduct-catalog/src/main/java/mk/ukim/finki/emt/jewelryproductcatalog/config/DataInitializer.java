package mk.ukim.finki.emt.jewelryproductcatalog.config;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.jewelryproductcatalog.domain.models.JewelryProduct;
import mk.ukim.finki.emt.jewelryproductcatalog.domain.repository.JewelryProductRepository;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final JewelryProductRepository productRepository;

    @PostConstruct
    public void initData() {
        JewelryProduct p1 = JewelryProduct.build("Belegzija Disney", "PANDORA","BELEGZIJA", Money.valueOf(Currency.MKD,500.0), 10);
        JewelryProduct p2 = JewelryProduct.build("Butterfly Ring", "SWAROWSKI" ,"PRSTEN",Money.valueOf(Currency.MKD,100.0), 5);
        System.out.println("AJDE VEKJE KRENIII>>>>>>>>");
        if (productRepository.findAll().isEmpty()) {
            productRepository.saveAll(Arrays.asList(p1,p2));
        }
    }
}
