package com.packt.cardatebase.domain;


import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand, model, color, registrationNumber;

    private int modelYear, price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner") //조인할때 쓸 컬럼명을 owner로 하겠다는 의미
    private Owner owner;
    // @JoinColumn
    public Car() {
    }

    public Car(String brand,String model, String color, String registrationNumber, int modelYear, int price, Owner owner) {
        this.brand = brand;
        this.color = color;
        this.model = model;
        this.modelYear = modelYear;
        this.price = price;
        this.registrationNumber = registrationNumber;
        this.owner=owner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}

