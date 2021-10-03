package com.example.demospringboot.controllers.Address;

import com.example.demospringboot.domain.Address;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AddressRestController {

    @Operation(summary = "Add a new address", description = "endpoint for creating an address", tags = {"address"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Order already exists")})
    public Address saveAddress(@RequestBody Address address);

    @Operation(summary = "Get All address", description = "endpoint for getting All address", tags = {"address"})
    public List<Address> getAllAddresses();

    @Operation(summary = "Get address by Id", description = "endpoint for getting address by ID", tags = {"address"})
    public Address getAddressById(@PathVariable long id);

    @Operation(summary = "Update order by Id", description = "endpoint for updating order by ID", tags = {"address"})
    public Address updateAddress(@PathVariable("id") long id, @RequestBody Address address);

    @Operation(summary = "Remove all Address", description = "endpoint for remove all address", tags = {"address"})
    public void removeAllAddresses();
}
