//package mk.ukim.finki.emt.jewelryordermanagment.domain.config;
//
//import lombok.AllArgsConstructor;
//import mk.ukim.finki.emt.jewelryordermanagment.domain.model.JewelryOrder;
//import mk.ukim.finki.emt.jewelryordermanagment.domain.model.OrderState;
//import mk.ukim.finki.emt.jewelryordermanagment.domain.repository.OrderRepository;
//import mk.ukim.finki.emt.jewelryordermanagment.domain.valueobjects.JewelryProduct;
//import mk.ukim.finki.emt.jewelryordermanagment.domain.valueobjects.UserId;
//import mk.ukim.finki.emt.jewelryordermanagment.xport.client.ProductClient;
//import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
//import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
//import org.hibernate.criterion.Order;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.time.Instant;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Component
//@AllArgsConstructor
//public class DataInitializer {
//
//    private final OrderRepository productRepository;
//
//    private final ProductClient productClient;
//
//    @PostConstruct
//    public void initData() {
//        List<JewelryProduct> productList = productClient.findAll();
//        JewelryProduct p1 = productList.get(0);
//
//        JewelryOrder order = JewelryOrder.build(Instant.now(), OrderState.PROCESSED,Currency.MKD, new HashSet<>(), UserId.randomId(UserId.class));
//
//
//        System.out.println("AJDE VEKJE KRENIII>>>>>>>>");
//        if (productRepository.findAll().isEmpty()) {
//            productRepository.saveAll(Arrays.asList(order));
//        }
//    }
//}
