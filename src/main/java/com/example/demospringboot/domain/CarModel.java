package com.example.demospringboot.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter @Setter
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String model;

    private long carAge;

    private long price;




    private String color;


    private Boolean originalColor  = Boolean.TRUE;



    @Override
    public String toString() {
        return "CarModel{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", carAge=" + carAge +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", originalColor=" + originalColor +
                '}';
    }
}
