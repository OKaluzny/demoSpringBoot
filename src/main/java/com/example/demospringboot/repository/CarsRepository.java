package com.example.demospringboot.repository;

import com.example.demospringboot.domain.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository <CarModel, Long>{

}
