package com.example.demospringboot.domain;

    import javax.persistence.*;

    @Entity
    @Table(name = "addresses")
    public class Address {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)

        private long id;

        private String country;

        private String city;

        private String distrikt;


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrikt() {
            return distrikt;
        }

        public void setDistrikt(String distrikt) {
            this.distrikt = distrikt;
        }
    }

