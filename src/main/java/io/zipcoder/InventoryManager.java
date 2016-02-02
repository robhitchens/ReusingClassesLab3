package io.zipcoder;

/**
 * Created by roberthitchens3 on 2/1/16.
 */
import java.util.Scanner;
public class InventoryManager {
    public static void main(String[] args){

    }
    private Inventory inventory;
    private static String options = "s for sum of values \n gi to get inventory value \n gp to get a particular product \n a to add item \n r to remove item \n i to increase quantity \n d to decrease quantity\n p to print\n q to quit";
    public InventoryManager(){
        inventory = new Inventory();
        run();
    }
    public void run(){
        String in = userInput("What would you like to do? (): ");
        System.out.println(options);
        Product p = null;
        while(!in.equals("q")){
            switch(in){
                case "s":
                    inventory.sumUpInventoryValue();
                    break;
                case "gi":
                    inventory.getInventoryValue();
                    break;
                case "gp":
                    inventory.getProduct(userInput("enter item name: "));
                    break;
                case "a":
                    p = new Product();
                    p.setId(userInput("enter product name: "));
                    p.setPrice(Double.parseDouble(userInput("enter product price: ")));
                    p.setQuantity(Integer.parseInt(userInput("enter quantity: "), 10));
                    inventory.addItem(p);
                    break;
                case "r":
                    p = inventory.removeProduct(userInput("enter product to remove: "));
                    System.out.println("removed "+p.getId());
                    break;
                case "i":
                    inventory.increaseQuantity(userInput("enter product name: "), Integer.parseInt(userInput("enter amount: "), 10));
                    break;
                case "d":
                    inventory.decreaseQuantity(userInput("enterproduct naemL "), Integer.parseInt(userInput("enter amount: ")));
                    break;
                case "p":
                    inventory.printInventory();
                    break;
            }
            System.out.println(options);
            in = userInput("what would you like to do? ");

        }
    }
    public String userInput(String message){//refactor and add filter
        Scanner uinput = new Scanner(System.in);
        System.out.println(message);
        return uinput.next();
    }


}
