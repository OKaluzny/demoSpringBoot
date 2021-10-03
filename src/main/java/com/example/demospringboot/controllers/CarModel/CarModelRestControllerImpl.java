package com.example.demospringboot.controllers.CarModel;

import com.example.demospringboot.domain.CarModel;
import com.example.demospringboot.repository.CarsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarModelRestControllerImpl implements CarModelRestController{


    private final CarsRepository carsRepository;

    public CarModelRestControllerImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    //Операция сохранения авто в базу данных
    @PostMapping("/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public CarModel saveCar (@RequestBody CarModel cars) {
        return carsRepository.save(cars);
    }

    //Получение списка авто
    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    public Collection<CarModel> getAllCar() {
        return carsRepository.findAll();
    }

    //Получения авто по id
    @GetMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarModel getCarById(@PathVariable long id) {
        return carsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id = Not found"));
    }
    /* TODO: //Получения авто по Model
            @GetMapping("/cars/{model}")
            @ResponseStatus(HttpStatus.OK)
            public CarModel getCarByModel(@PathVariable String model) {
                return (CarModel) repository.findByModel(model);

            }

               TODO: //Получения авто по CarAge
                @GetMapping("/cars/{carAge}")
                @ResponseStatus(HttpStatus.OK)
                public CarModel getCarByCarAge(@PathVariable long carAge) {
                    return repository.findByCarAge(carAge)
                            .orElseThrow(() -> new EntityNotFoundException("Entity with carAge = Not found"));
                }

               TODO: //Получения авто по Price
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

        CarModel car = carsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with id = Not found"));
        car.setColor(carModel.getColor());
        car.setOriginalColor(Boolean.FALSE);
        return carsRepository.save(car);
    }

/* TODO: //Получение списка авто только в оригинальном цвете
    @GetMapping("/cars/originalColor")
    @ResponseStatus(HttpStatus.OK)
    public Collection<CarModel> getAllCarWithOriginalColor() {
        return ;
    }*/
    @PutMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarModel refreshCarModel(@PathVariable("id") long id, @RequestBody CarModel carModel) {


        return carsRepository.findById(id)
                .map(entity -> {

                    entity.setModel(carModel.getModel());
                    entity.setCarAge(carModel.getCarAge());
                    entity.setPrice(carModel.getPrice());
                    return carsRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Employee with id = Not found"));

    }


    //Удаление по id
    @DeleteMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCarById(@PathVariable long id) {
        carsRepository.deleteById(id);

    }

    //Удаление всех юзеров
    @DeleteMapping("/cars")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllCars() {
        carsRepository.deleteAll();
    }
}
