package com.example.demospringboot.web;

import com.example.demospringboot.domain.CarModel;
import com.example.demospringboot.domain.CarModelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarModelRestController {


    private final CarModelRepository repository;

    public CarModelRestController(CarModelRepository repository) {
        this.repository = repository;
    }

    //Операция сохранения авто в базу данных
    @PostMapping("/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public CarModel saveCar (@RequestBody CarModel cars) {

        return repository.save(cars);

    }

    //Получение списка авто
    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    public Collection<CarModel> getAllCar() {

        return repository.findAll();

    }

    //Получения авто по id
    @GetMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarModel getCarById(@PathVariable long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id = Not found"));
    }
    /*
            //Получения авто по Model
            @GetMapping("/cars/{model}")
            @ResponseStatus(HttpStatus.OK)
            public CarModel getCarByModel(@PathVariable String model) {
                return (CarModel) repository.findByModel(model);

            }

               //Получения авто по CarAge
                @GetMapping("/cars/{carAge}")
                @ResponseStatus(HttpStatus.OK)
                public CarModel getCarByCarAge(@PathVariable long carAge) {

                    return repository.findByCarAge(carAge)
                            .orElseThrow(() -> new EntityNotFoundException("Entity with carAge = Not found"));
                }

                //Получения авто по Price
                @GetMapping("/cars/{price}")
                @ResponseStatus(HttpStatus.OK)
                public CarModel getCarByPrice(@PathVariable long price) {

                    return repository.findByPrice(price)
                            .orElseThrow(() -> new EntityNotFoundException("Entity with price = Not found"));
                }
                */
    //Проверка оригинальный цвет у авто или нет
    @PatchMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarModel refreshCarColor(@PathVariable("id") long id, @RequestBody CarModel carModel) {

        CarModel car = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with id = Not found"));
        car.setColor(carModel.getColor());
        car.setOriginalColor(Boolean.FALSE);
        return repository.save(car);
    }

/*    //Получение списка авто только в оригинальном цвете
    @GetMapping("/cars/originalColor")
    @ResponseStatus(HttpStatus.OK)
    public Collection<CarModel> getAllCarWithOriginalColor() {
        return ;
    }*/
    @PutMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarModel refreshCarModel(@PathVariable("id") long id, @RequestBody CarModel carModel) {


        return repository.findById(id)
                .map(entity -> {

                    entity.setModel(carModel.getModel());
                    entity.setCarAge(carModel.getCarAge());
                    entity.setPrice(carModel.getPrice());
                    return repository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Employee with id = Not found"));

    }


    //Удаление по id
    @DeleteMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCarById(@PathVariable long id) {
        repository.deleteById(id);

    }

    //Удаление всех юзеров
    @DeleteMapping("/cars")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllCars() {
        repository.deleteAll();
    }
}
