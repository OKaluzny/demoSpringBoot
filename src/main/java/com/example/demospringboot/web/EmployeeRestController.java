package com.example.demospringboot.web;

import com.example.demospringboot.config.EmployeeConverter;
import com.example.demospringboot.domain.Employee;
import com.example.demospringboot.dto.EmployeeDto;
import com.example.demospringboot.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Employee", description = "Employee API")

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeRestController {

    private final EmployeeService service;
    private final EmployeeConverter converter;

    public EmployeeRestController(EmployeeService service, EmployeeConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new employee", description = "endpoint for creating an entity", tags = {"Employee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Employee already exists")})
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto requestForSave) {

        Employee employee = converter.getMapperFacade().map(requestForSave, Employee.class);
        EmployeeDto dto = converter.toDto(service.saveEmployee(employee));

        return dto;
    }

    //Получение списка юзеров
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDto> getAllUsers() {

        return null;
    }

    //Получения юзера по id
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDto getEmployeeById(@PathVariable long id) {
        Employee entity = service.getEmployeeById(id);
        EmployeeDto dto = converter.toDto(entity);
        return dto;
    }

    //Обновление юзера
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDto refreshEmployee(@PathVariable("id") long id, @RequestBody EmployeeDto requestForUpdate) {

        Employee entity = service.getEmployeeById(id);
        converter.getMapperFacade().map(requestForUpdate, entity);
        EmployeeDto dto = converter.toDto(service.updateEmployee(entity));

        return dto;
    }

    //Удаление по id
    //@DeleteMapping("/users/{id}")
    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmployeeById(@PathVariable long id) {

        service.removeEmployeeById(id);
    }

    //Удаление всех юзеров
    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllUsers() {
        service.removeAllUsers();
    }
}
