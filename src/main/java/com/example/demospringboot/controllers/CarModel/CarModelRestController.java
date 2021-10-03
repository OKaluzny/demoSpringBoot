package com.example.demospringboot.controllers.CarModel;

import com.example.demospringboot.domain.CarModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

public interface CarModelRestController {
    @Operation(summary = "Add a new CarModel", description = "endpoint for creating an CarModel", tags = {"CarModel"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CarModel created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "CarModel already exists")})
    public CarModel saveCar (@RequestBody CarModel cars);

    @Operation(summary = "Get All CarModel", description = "endpoint for getting All CarModel", tags = {"CarModel"})
    public Collection<CarModel> getAllCar();

    @Operation(summary = "Get CarModel by Id", description = "endpoint for getting CarModel by ID", tags = {"CarModel"})
    public CarModel getCarById(@PathVariable long id);

    @Operation(summary = "Update CarModel by Id", description = "endpoint for updating CarModel by ID", tags = {"CarModel"})
    public CarModel refreshCarColor(@PathVariable("id") long id, @RequestBody CarModel carModel);

    @Operation(summary = "Update CarModel by Id", description = "endpoint for updating CarModel by ID", tags = {"CarModel"})
    public CarModel refreshCarModel(@PathVariable("id") long id, @RequestBody CarModel carModel);

    @Operation(summary = "Remove all CarModel", description = "endpoint for remove all CarModel", tags = {"CarModel"})
    public void removeCarById(@PathVariable long id);

    @Operation(summary = "Remove all CarModel", description = "endpoint for remove all CarModel", tags = {"CarModel"})
    public void removeAllCars();
}
