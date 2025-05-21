package com.tomaszek.carscatalog.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Brand cannot be empty")
    private String brand;

    @NotBlank(message = "Model cannot be empty")
    private String model;

    @Positive(message = "Year of production must be greater than 0")
    private int yearOfProduction;

    @NotBlank(message = "Color cannot be empty")
    private String color;

    @NotBlank(message = "Engine cannot be empty")
    private String engine;

    @Positive(message = "Horse Power must be greater than 0")
    private int horsePower;

    @Positive(message = "Price must be greater than 0")
    private Double price;

    public Car() {}

    public Car(int id, String brand, String model, int yearOfProduction, String color, String engine, int horsePower, Double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.color = color;
        this.engine = engine;
        this.horsePower = horsePower;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
