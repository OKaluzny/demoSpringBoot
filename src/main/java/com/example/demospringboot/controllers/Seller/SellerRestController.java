package com.example.demospringboot.controllers.Seller;

import com.example.demospringboot.domain.Seller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface SellerRestController {
    @Operation(summary = "Add a new address", description = "endpoint for creating an seller", tags = {"seller"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Seller created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Seller already exists")})
    public Seller saveSeller(@RequestBody Seller seller);

    @Operation(summary = "Get All seller", description = "endpoint for getting All seller", tags = {"seller"})
    public List<Seller> getAllSeller();

    @Operation(summary = "Get seller by Id", description = "endpoint for getting seller by ID", tags = {"seller"})
    public Seller getSellerById(@PathVariable long id);

    @Operation(summary = "Update seller by Id", description = "endpoint for updating seller by ID", tags = {"seller"})
    public Seller updateSeller(@PathVariable("id") long id, @RequestBody Seller seller);

    @Operation(summary = "Remove all seller", description = "endpoint for remove all seller", tags = {"seller"})
    public void removeAllSeller();
}
