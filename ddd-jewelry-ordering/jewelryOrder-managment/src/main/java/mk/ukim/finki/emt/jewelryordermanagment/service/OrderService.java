package mk.ukim.finki.emt.jewelryordermanagment.service;

import mk.ukim.finki.emt.jewelryordermanagment.domain.exceptions.JewelryOrderIdNotExistException;
import mk.ukim.finki.emt.jewelryordermanagment.domain.exceptions.JewelryOrderItemIdNotExistException;
import mk.ukim.finki.emt.jewelryordermanagment.domain.model.JewelryOrder;
import mk.ukim.finki.emt.jewelryordermanagment.domain.model.OrderId;
import mk.ukim.finki.emt.jewelryordermanagment.domain.model.JewelryItemId;
import mk.ukim.finki.emt.jewelryordermanagment.service.forms.OrderForm;
import mk.ukim.finki.emt.jewelryordermanagment.service.forms.OrderItemForm;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    OrderId placeOrder(OrderForm orderForm);

    List<JewelryOrder> findAll();

    Optional<JewelryOrder> findById(OrderId id);

    void addItem(OrderId orderId, OrderItemForm orderItemForm) throws JewelryOrderIdNotExistException;

    void deleteItem(OrderId orderId, JewelryItemId orderItemId) throws JewelryOrderIdNotExistException, JewelryOrderItemIdNotExistException;

}
