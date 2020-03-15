package com.example.spusapp.Transaction;

public class Product {
    private String images;
    private String name;
    private int qty;
    private int price;
//    private double rating;

    public Product(String images, String name, int qty, int price) {
        this.images = images;
        this.name = name;
        this.qty = qty;
        this.price = price;
//        this.rating = rating;
    }

    public String getImages() {
        return images;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }

//    public double getRating() {
//        return rating;
//    }
}
