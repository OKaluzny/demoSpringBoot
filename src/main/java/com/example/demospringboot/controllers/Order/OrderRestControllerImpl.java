package com.example.demospringboot.controllers.Order;

import com.example.demospringboot.domain.Order;
import com.example.demospringboot.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderRestControllerImpl implements OrderRestController{
    private final OrderRepository orderRepository;

    public OrderRestControllerImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    //Сохранение заказа
    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Order saveOrder (@RequestBody Order order) {
        return orderRepository.save(order);
    }

    //Получение всех заказов
    @GetMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    //Получение заказа по id
    @GetMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrderById(@PathVariable long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id = " + id));
        return order;
    }


    //Обновление заказа по id
    @PutMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order updateOrder(@PathVariable("id") long id, @RequestBody Order order) {

        return orderRepository.findById(id)
                .map(entity -> {
                    entity.setStatus(order.getStatus());
                    entity.setTotalPrice(order.getTotalPrice());
                    entity.setId(order.getId());
                    return orderRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id = " + id));
    }

    //Удаление всех записей
    @DeleteMapping("/orders")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllOrder() {
        orderRepository.deleteAll();
    }
}
