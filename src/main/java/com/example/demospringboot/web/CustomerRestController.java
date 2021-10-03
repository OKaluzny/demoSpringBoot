package com.example.demospringboot.web;


import com.example.demospringboot.domain.Customer;
import com.example.demospringboot.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;


    @RestController
    @RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
    public class CustomerRestController {

        private final CustomerRepository customerRepository;

        public CustomerRestController(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        //Сохранение пользователя
        @PostMapping("/customers")
        @ResponseStatus(HttpStatus.CREATED)
        public Customer saveCustomer(@RequestBody Customer customer) {
            return customerRepository.save(customer);
        }

        //Получение всех пользователей
        @GetMapping("/customers")
        @ResponseStatus(HttpStatus.OK)
        public List<Customer> getAllCustomer() {
            return customerRepository.findAll();
        }

        //Получение пользователя по id
        @GetMapping("/customers/{id}")
        @ResponseStatus(HttpStatus.OK)
        public Customer getCustomerById(@PathVariable long id) {

            Customer customer = customerRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Customer not found with id = " + id));
            return customer;
        }


        //Обновление пользователя по id
        @PutMapping("/customers/{id}")
        @ResponseStatus(HttpStatus.OK)
        public Customer updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {

            return customerRepository.findById(id)
                    .map(entity -> {
                        entity.setEmail(customer.getEmail());
                        entity.setPhone(customer.getPhone());
                        entity.setId(customer.getId());
                        return customerRepository.save(entity);
                    })
                    .orElseThrow(() -> new EntityNotFoundException("Customer not found with id = " + id));
        }

        //Удаление всех пользователей
        @DeleteMapping("/customers")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void removeAllCustomer() {
            customerRepository.deleteAll();
        }
    }
