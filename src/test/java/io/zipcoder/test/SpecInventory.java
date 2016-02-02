package io.zipcoder.test;

/**
 * Created by roberthitchens3 on 2/1/16.
 */
import org.junit.Test;
import static org.junit.Assert.*;
import io.zipcoder.Inventory;
import io.zipcoder.Product;
public class SpecInventory {
    Inventory in = new Inventory();
    @Test
    public void testAddItemRemoveItemGetProduct(){
        Product cf = new Product();
        cf.setId("Corn Flakes");
        cf.setPrice(2.39);
        cf.setQuantity(25);
        in.addItem(cf);
        assertTrue("returned product should be equal to original product",cf.equals(in.getProduct("Corn Flakes")));
        Product rcf = in.removeProduct(cf.getId());
        //assertTrue();
    }
    @Test
    public void testIncreaseDecreaseQuantity(){
        Product cf = new Product();
        cf.setId("Corn Flakes");
        cf.setPrice(2.39);
        cf.setQuantity(25);
        in.addItem(cf);
        in.increaseQuantity("Corn Flakes", 5);
        assertTrue(cf.getQuantity() == 30);
        in.decreaseQuantity("Corn Flakes", 5);
        assertTrue(cf.getQuantity() == 25);
    }
    @Test
    public void testSumUpInventory(){
        Product cf = new Product();
        cf.setId("Corn Flakes");
        cf.setPrice(2.39);
        cf.setQuantity(25);
        in.addItem(cf);
        in.sumUpInventoryValue();
        double value = in.getInventoryValue();
        assertEquals(value, 2.39, 0.001);

    }



}
