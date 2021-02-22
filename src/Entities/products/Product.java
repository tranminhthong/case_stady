package Entities.products;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private int code;
    private String brand;
    private double weight;
    private double size;
    private String color;
    private long price;

    public Product() {
    }

    public Product(int id, String name, int code, String brand, double weight, double size, String color, long price) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.brand = brand;
        this.weight = weight;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", brand='" + brand + '\'' +
                ", weight=" + weight +
                ", size=" + size +
                ", color='" + color + '\'' +
                ", price=" + price;
    }
}
