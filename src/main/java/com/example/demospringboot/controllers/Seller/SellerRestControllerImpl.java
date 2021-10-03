package com.example.demospringboot.controllers.Seller;

import com.example.demospringboot.domain.Seller;
import com.example.demospringboot.repository.SellerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class SellerRestControllerImpl implements SellerRestController{

    private final SellerRepository sellerRepository;

    public SellerRestControllerImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    //Сохранение продавца
    @PostMapping("/sellers")
    @ResponseStatus(HttpStatus.CREATED)
    public Seller saveSeller(@RequestBody Seller seller) {
        return sellerRepository.save(seller);
    }

    //Получение всех продавцов
    @GetMapping("/sellers")
    @ResponseStatus(HttpStatus.OK)
    public List<Seller> getAllSeller() {
        return sellerRepository.findAll();
    }

    //Получение продавца по id
    @GetMapping("/sellers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Seller getSellerById(@PathVariable long id) {

        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seller not found with id = " + id));
        return seller;
    }


    //Обновление продавца по id
    @PutMapping("/sellers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Seller updateSeller(@PathVariable("id") long id, @RequestBody Seller seller) {

        return sellerRepository.findById(id)
                .map(entity -> {
                    entity.setEmail(seller.getEmail());
                    entity.setPhone(seller.getPhone());
                    entity.setId(seller.getId());
                    return sellerRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Seller not found with id = " + id));
    }

    //Удаление всех продавцов
    @DeleteMapping("/sellers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllSeller() {
        sellerRepository.deleteAll();
    }
}
