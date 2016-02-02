package io.zipcoder;

/**
 * Created by roberthitchens3 on 2/1/16.
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InventoryManager {
    public static void main(String[] args){
        InventoryManager man = new InventoryManager();
    }
    private Inventory inventory;
    private static String options = " s for sum of values  " +
            "\n gp to get a particular product \n a to add item \n r to remove item " +
            "\n i to increase quantity \n d to decrease quantity\n p to print\n q to quit";
    public InventoryManager(){
        inventory = new Inventory();
        run();
    }
    public void run(){
        System.out.println(options);
        String in = userInput("What would you like to do? (): ", "");
        Product p = null;
        while(!in.equals("q")){
            switch(in){
                case "s":
                    inventory.sumUpInventoryValue();
                    System.out.println("total inventory value: "+inventory.getInventoryValue());
                    break;
                /*case "gi":
                    System.out.println("total inventory value: "+inventory.getInventoryValue());
                    break;*/
                case "gp":
                    inventory.getProduct(userInput("enter item name: ",""));
                    break;
                case "a":
                    p = new Product();
                    p.setId(userInput("enter product name: ",""));
                    p.setPrice(Double.parseDouble(userInput("enter product price: ","number")));
                    p.setQuantity(Integer.parseInt(userInput("enter quantity: ","number"), 10));
                    inventory.addItem(p);
                    break;
                case "r":
                    try {
                        p = inventory.removeProduct(userInput("enter product to remove: ", ""));
                        System.out.println("removed "+p.getId());
                    }catch(NullPointerException e){
                        System.out.println("product not in inventory, or entered value is not product.");
                    }

                    break;
                case "i":
                    inventory.increaseQuantity(userInput("enter product name: ", ""), Integer.parseInt(userInput("enter amount: ", "number"), 10));
                    break;
                case "d":
                    inventory.decreaseQuantity(userInput("enter product name: ", ""), Integer.parseInt(userInput("enter amount: ", "number"), 10));
                    break;
                case "p":
                    inventory.printInventory();
                    break;
            }
            System.out.println(options);
            in = userInput("what would you like to do? ", "");

        }
    }
    public String userInput(String message, String type){//refactor and add filter
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String input = scanner.nextLine();

        if(type.equals("number")){
            String pattern = "(.*)\\d+(\\.\\d{1,2}?)?(.*)";//should find number with decimal value or number without decimal value.
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(input);
            boolean okay =false;
            while(!okay){
                if(m.find()){
                    okay = true;
                    return input;

                }else{
                    System.out.println("entered value is invalid enter new Value: ");
                    input = scanner.next();
                    m = p.matcher(input);
                }
            }

        }

        return input;
    }


}
