package mk.ukim.finki.emt.jewelryordermanagment.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.jewelryordermanagment.domain.exceptions.JewelryOrderIdNotExistException;
import mk.ukim.finki.emt.jewelryordermanagment.domain.exceptions.JewelryOrderItemIdNotExistException;
import mk.ukim.finki.emt.jewelryordermanagment.domain.model.JewelryOrder;
import mk.ukim.finki.emt.jewelryordermanagment.domain.model.OrderId;
import mk.ukim.finki.emt.jewelryordermanagment.domain.model.JewelryItemId;
import mk.ukim.finki.emt.jewelryordermanagment.domain.repository.OrderRepository;
import mk.ukim.finki.emt.jewelryordermanagment.service.OrderService;
import mk.ukim.finki.emt.jewelryordermanagment.service.forms.OrderForm;
import mk.ukim.finki.emt.jewelryordermanagment.service.forms.OrderItemForm;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final Validator validator;

    @Override
    public OrderId placeOrder(OrderForm orderForm) {
        Objects.requireNonNull(orderForm,"order must not be null.");
        var constraintViolations = validator.validate(orderForm);
        if (constraintViolations.size()>0) {
            throw new ConstraintViolationException("The order form is not valid", constraintViolations);
        }
        var newOrder = orderRepository.saveAndFlush(toDomainObject(orderForm));
        return newOrder.getId();
    }

    @Override
    public List<JewelryOrder> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<JewelryOrder> findById(OrderId id) {
        return orderRepository.findById(id);
    }

    @Override
    public void addItem(OrderId orderId, OrderItemForm orderItemForm) throws JewelryOrderIdNotExistException {
        JewelryOrder order = orderRepository.findById(orderId).orElseThrow(JewelryOrderIdNotExistException::new);
        order.addItem(orderItemForm.getProduct(),orderItemForm.getQuantity());
        orderRepository.saveAndFlush(order);
    }

    @Override
    public void deleteItem(OrderId orderId, JewelryItemId orderItemId) throws JewelryOrderIdNotExistException, JewelryOrderItemIdNotExistException {
        JewelryOrder order = orderRepository.findById(orderId).orElseThrow(JewelryOrderIdNotExistException::new);
        order.removeItem(orderItemId);
        orderRepository.saveAndFlush(order);
    }

    private JewelryOrder toDomainObject(OrderForm orderForm) {
        var order = new JewelryOrder(Instant.now(),orderForm.getCurrency(),orderForm.getUserId());
        orderForm.getItems().forEach(item->order.addItem(item.getProduct(),item.getQuantity()));
        return order;
    }

}
