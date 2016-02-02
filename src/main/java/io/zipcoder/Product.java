package io.zipcoder;

/**
 * Created by roberthitchens3 on 2/1/16.
 */
public class Product {
    private double price;
    private String id;
    private int quantity;

    public void setPrice(double price){
        this.price = price;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public double getPrice(){return price;}
    public String getId(){return id;}
    public int getQuantity(){return quantity;}
}
