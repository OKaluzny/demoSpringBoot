package com.example.demospringboot.dto;

import com.example.demospringboot.domain.Address;
import io.swagger.v3.oas.annotations.media.Schema;

public class EmployeeDto {

    private Long id;

    @Schema(description = "Name of the employee.", example = "Vasil", required = true)
    private String name;

    private String email;

    private String country;

    private Boolean isDeleted = Boolean.FALSE;

    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
