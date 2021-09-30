package com.example.demospringboot.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter@Setter
@Table(name = "cars")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "model")
    private String model;
    @Column(name = "carAge")
    private long carAge;
    @Column(name = "price")
    private long price;
    @Column(name = "color")
    private String color;
    @Column(name = "originalColor")
    private Boolean originalColor = Boolean.TRUE;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "address_fk")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Address address;

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