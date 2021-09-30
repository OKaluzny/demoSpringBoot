package com.example.demospringboot.web;

import com.example.demospringboot.domain.Address;
import com.example.demospringboot.repository.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressRestController {

    private final AddressRepository addressRepository;

    public AddressRestController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    //Сохранение адреса
    @PostMapping("/addresses")
    @ResponseStatus(HttpStatus.CREATED)
    public Address saveAddress(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    //Получение всех адресов
    @GetMapping("/addresses")
    @ResponseStatus(HttpStatus.OK)
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    //Получение адреса по id
    @GetMapping("/addresses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Address getAddressById(@PathVariable long id) {

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id = " + id));
        return address;
    }


    //Обновление адреса по id
    @PutMapping("/addresses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Address updateAddress(@PathVariable("id") long id, @RequestBody Address address) {

        return addressRepository.findById(id)
                .map(entity -> {
                    entity.setCity(address.getCity());
                    entity.setCountry(address.getCountry());
                    entity.setZipCode(address.getZipCode());
                    return addressRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id = " + id));
    }

    //Удаление всех записей
    @DeleteMapping("/addresses")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllAddresses() {
        addressRepository.deleteAll();
    }
}
