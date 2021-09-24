package com.example.demospringboot.domain;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String model;

    private long carAge;

    private long price;

    private String color;

    private Boolean originalColor  = Boolean.TRUE;

    @NotNull
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getCarAge() {
        return carAge;
    }

    public void setCarAge(long carAge) {
        this.carAge = carAge;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getOriginalColor() {
        return originalColor;
    }

    public void setOriginalColor(Boolean originalColor) {
        this.originalColor = originalColor;
    }

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
