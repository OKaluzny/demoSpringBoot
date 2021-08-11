package com.example.demospringboot.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {

    List<CarModel> findByModel(String model);

    List<CarModel> findByPrice(long price);
    List<CarModel> findByCarAge(long carAge);

}
