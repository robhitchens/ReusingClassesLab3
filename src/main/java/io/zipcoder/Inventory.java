package io.zipcoder;

/**
 * Created by roberthitchens3 on 2/1/16.
 */
import java.util.HashMap;
import java.util.Scanner;

public class Inventory {
    private HashMap<String, Product> inventory;
    private double value;

    public Inventory(){
        this.inventory = new HashMap<String, Product>();
    }
    public void sumUpInventoryValue(){
        double total = 0.0;
        for(String s : inventory.keySet()){
            total += (inventory.get(s).getPrice()*inventory.get(s).getQuantity());
        }
        value = total;
    }
    public double getInventoryValue(){
        return value;
    }
    public Product getProduct(String itemId){
        return inventory.get(itemId);
    }
    public void addItem(Product prod){
        inventory.put(prod.getId(), prod);
    }
    public Product removeProduct(String prod){
        if(inventory.keySet().contains(prod)) {
            return inventory.remove(prod);
        }else {
            return null;
        }
    }
    public void increaseQuantity(String itemId, int amount){
        int initQuantity =inventory.get(itemId).getQuantity();
        inventory.get(itemId).setQuantity(initQuantity+amount);
    }
    public void decreaseQuantity(String itemId, int amount){
        int initQuantity =inventory.get(itemId).getQuantity();
        inventory.get(itemId).setQuantity(initQuantity-amount);
    }
    public void printInventory(){
        System.out.println("***** INVENTORY *****");
        for(String s : inventory.keySet()){
            Product p = inventory.get(s);
            System.out.println(p.getId() + " cost: $" + p.getPrice() + " Quantity: "+ p.getQuantity());
        }
        System.out.println("*********************");
    }

}
