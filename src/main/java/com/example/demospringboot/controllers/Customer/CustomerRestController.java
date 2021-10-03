package com.example.demospringboot.controllers.Customer;

import com.example.demospringboot.domain.Customer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface CustomerRestController {
    @Operation(summary = "Add a new Customer", description = "endpoint for creating an Customer", tags = {"Customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Customer already exists")})
    public Customer saveCustomer(@RequestBody Customer customer);

    @Operation(summary = "Get All Customer", description = "endpoint for getting All Customer", tags = {"Customer"})
    public List<Customer> getAllCustomer();

    @Operation(summary = "Get Customer by Id", description = "endpoint for getting Customer by ID", tags = {"Customer"})
    public Customer getCustomerById(@PathVariable long id);

    @Operation(summary = "Update order by Id", description = "endpoint for updating Customer by ID", tags = {"Customer"})
    public Customer updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer);

    @Operation(summary = "Remove all Customer", description = "endpoint for remove all Customer", tags = {"Customer"})
    public void removeAllCustomer();
}
