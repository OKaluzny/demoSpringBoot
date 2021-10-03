package com.example.demospringboot.controllers.Order;

import com.example.demospringboot.domain.Order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface OrderRestController {
    @Operation(summary = "Add a new order", description = "endpoint for creating an order", tags = {"order"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Order already exists")})
    public Order saveOrder (@RequestBody Order order);

    @Operation(summary = "Get All order", description = "endpoint for getting All order", tags = {"order"})
    public List<Order> getAllOrder();

    @Operation(summary = "Get order by Id", description = "endpoint for getting order by ID", tags = {"order"})
    public Order getOrderById(@PathVariable long id);

    @Operation(summary = "Update order by Id", description = "endpoint for updating order by ID", tags = {"order"})
    public Order updateOrder(@PathVariable("id") long id, @RequestBody Order order);

    @Operation(summary = "Remove all order", description = "endpoint for remove all order", tags = {"order"})
    public void removeAllOrder();
}
