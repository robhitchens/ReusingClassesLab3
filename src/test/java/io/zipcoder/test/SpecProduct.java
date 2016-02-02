package io.zipcoder.test;

/**
 * Created by roberthitchens3 on 2/1/16.
 */
import org.junit.Test;
import static org.junit.Assert.*;
import io.zipcoder.Product;
public class SpecProduct {


    @Test
    public void testIdMethods(){
        Product p = new Product();
        p.setId("peas");
        String retValue = p.getId();
        assertNotNull("returned value should not be null: ", retValue);
        assertEquals("teh returned value should be equal to the set value: ", "peas", retValue);
    }
    @Test
    public void testPriceMethods(){
        Product cf = new Product();
        cf.setPrice(2.39);
        double price = cf.getPrice();
        assertNotEquals("returned value should not be -1: ",-1,price);
        assertEquals("returned value should be equal to given value", 2.39, price, 0.001);
    }
    @Test
    public void testQuantityMethods(){
        Product soup = new Product();
        soup.setQuantity(5);
        int q = soup.getQuantity();
        assertNotEquals("returned value should not be -1", -1, q);
        assertEquals("returned value and set value should be equal: ", 5, q);
    }
}
