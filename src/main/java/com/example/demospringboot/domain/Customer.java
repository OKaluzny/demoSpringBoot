package com.example.demospringboot.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "customers")
@Getter @Setter
public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private long id;

        private String name;

        private int phone;

        private String email;

        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name = "address_fk")
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private Customer customer;

        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name = "order_fk")
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private Order order;
    }

