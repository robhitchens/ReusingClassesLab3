package io.zipcoder.test;

/**
 * Created by roberthitchens3 on 2/1/16.
 */
import io.zipcoder.InventoryManager;
import org.junit.Test;
import static org.junit.Assert.*;
public class SpecInventoryManager {

    InventoryManager inman = new InventoryManager();
    public void testUserInput() {
        String input = "2.39 \n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        String output = inman.userInput("enter a price: ", "number");
        assertNotNull("returned value should not be null: ", output);
        assertEquals("returned value should be equal to initial input value: ", "2.39", output);
    }
}
