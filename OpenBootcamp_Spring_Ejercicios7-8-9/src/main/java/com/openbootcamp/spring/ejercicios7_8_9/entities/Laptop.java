package com.openbootcamp.spring.ejercicios7_8_9.entities;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "laptops")
@ApiModel("Entidad Laptop: Representa Laptops de la tienda IT Whatever")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ApiModelProperty("Marca del laptop")
    private String brand;
    @ApiModelProperty("Modelo del laptop")
    private String model;
    @ApiModelProperty("CPU del laptop, marca i versión")
    private String cpu;
    @ApiModelProperty("Tamaño de la memoria RAM en GB")
    private String ram;
    @ApiModelProperty("Color del laptop")
    private String color;
    @ApiModelProperty("Precio en € y dos decimales")
    private double price;

    public Laptop() {
    }

    public Laptop(Long id, String brand, String model, String cpu, String ram, String color, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.cpu = cpu;
        this.ram = ram;
        this.color = color;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setModel(String model) { this.model = model; }

    public String getCpu() { return cpu; }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() { return ram; }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }
}
