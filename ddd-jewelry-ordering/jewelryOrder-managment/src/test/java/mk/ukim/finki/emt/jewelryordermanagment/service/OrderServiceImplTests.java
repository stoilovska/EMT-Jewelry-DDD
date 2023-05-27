package mk.ukim.finki.emt.jewelryordermanagment.service;

import mk.ukim.finki.emt.jewelryordermanagment.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.emt.jewelryordermanagment.domain.model.JewelryOrder;
import mk.ukim.finki.emt.jewelryordermanagment.domain.model.OrderId;
import mk.ukim.finki.emt.jewelryordermanagment.domain.valueobjects.JewelryId;
import mk.ukim.finki.emt.jewelryordermanagment.domain.valueobjects.JewelryProduct;
import mk.ukim.finki.emt.jewelryordermanagment.domain.valueobjects.User;
import mk.ukim.finki.emt.jewelryordermanagment.domain.valueobjects.UserId;
import mk.ukim.finki.emt.jewelryordermanagment.service.forms.OrderForm;
import mk.ukim.finki.emt.jewelryordermanagment.service.forms.OrderItemForm;
import mk.ukim.finki.emt.jewelryordermanagment.xport.client.ProductClient;
import mk.ukim.finki.emt.jewelryordermanagment.xport.client.UserClient;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Address;
import mk.ukim.finki.emt.sharedkernel.domain.valueobjects.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class OrderServiceImplTests {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private UserClient userClient;


    private static JewelryProduct newProduct(String name, String manufacturer, String category, Money price) {
        JewelryProduct p = new JewelryProduct(JewelryId.randomId(JewelryId.class), name, manufacturer, category, price, 0);
        return p;
    }

    private static User newUser(String name, String surname, Role role, Address address) {
        User u = new User(UserId.randomId(UserId.class), name, surname, role, address);
        return u;
    }

    @Test
    public void testPlaceOrder() {

        OrderItemForm oi1 = new OrderItemForm();
        oi1.setProduct(newProduct("Gema Belegzija", "PANDORA", "BELEGZIJA", Money.valueOf(Currency.MKD, 1500)));
        oi1.setQuantity(1);
        oi1.setMoney(new Money(Currency.MKD, 100.0));
        oi1.setUserId(new UserId("1"));

        OrderItemForm oi2 = new OrderItemForm();
        oi2.setProduct(newProduct("Blue ring", "SWAROVSKI", "PRSTEN", Money.valueOf(Currency.MKD, 500)));
        oi2.setQuantity(2);
        oi2.setMoney(new Money(Currency.MKD, 100.0));
        oi2.setUserId(new UserId("1"));


        OrderForm orderForm = new OrderForm();
        orderForm.setCurrency(Currency.MKD);
        orderForm.setUserId(new UserId("1"));
        orderForm.setAmount(10000.0);
        orderForm.setItems(Arrays.asList(oi1, oi2));

        OrderId newOrderId = orderService.placeOrder(orderForm);
        JewelryOrder newOrder = orderService.findById(newOrderId).orElseThrow(OrderIdNotExistException::new);
        System.out.println(newOrder.total().getAmount() + " " + newOrder.total().getCurrency());
        Assertions.assertEquals(newOrder.total(), Money.valueOf(Currency.MKD, 2500.0));

    }

    @Test
    public void testPlaceOrderWithRealData() {
        List<JewelryProduct> productList = productClient.findAll();
        List<User> userList = userClient.findAll();

        JewelryProduct p1 = productList.get(0);
        JewelryProduct p2 = productList.get(1);
        User u1 = userList.get(0);
        User u2 = userList.get(1);

        OrderItemForm oi1 = new OrderItemForm();
        oi1.setProduct(p1);
        oi1.setUserId(u1.getUserId());
        oi1.setMoney(new Money(Currency.MKD, 100.0));
        oi1.setQuantity(1);

        OrderItemForm oi2 = new OrderItemForm();
        oi2.setProduct(p2);
        oi2.setUserId(u2.getUserId());
        oi2.setMoney(new Money(Currency.MKD, 100.0));
        oi2.setQuantity(2);

        OrderForm orderForm = new OrderForm();
        orderForm.setCurrency(Currency.MKD);
        orderForm.setUserId(u1.getUserId());
        orderForm.setAmount(10000.0);
        orderForm.setItems(Arrays.asList(oi1, oi2));

//        System.out.println("DATA");
//        System.out.println(orderForm.getItems()+" "+orderForm.getAmount()+" "+orderForm.getCurrency()+" "+orderForm.getUserId());

        OrderId newOrderId = orderService.placeOrder(orderForm);
        JewelryOrder newOrder = orderService.findById(newOrderId).orElseThrow(OrderIdNotExistException::new);

//        System.out.println("DATA");
//        System.out.println(p1.getMoney().getAmount()+" "+p1.getMoney().getCurrency());

        Money outMoney = p1.getMoney().multiply(oi1.getQuantity()).add(p2.getMoney().multiply(oi2.getQuantity()));
        Assertions.assertEquals(newOrder.total(), outMoney);
    }

}
