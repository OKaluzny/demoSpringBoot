package com.example.demospringboot.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String status;

    private long totalPrice;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "address_fk")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Address address;
}
