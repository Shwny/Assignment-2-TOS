package it.unipd.tos;

import it.unipd.tos.model.MenuItem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuItemTest {

    @Test
    public void testGetType(){
        MenuItem i = new MenuItem(MenuItem.itemType.PANINI, "CHEESEBURGER", 5.00);
        assertEquals(i.getType(), MenuItem.itemType.PANINI);
    }

    @Test
    public void testGetName(){
        MenuItem i = new MenuItem(MenuItem.itemType.FRITTI, "CHICKEN NUGGET", 4.00);
        assertEquals(i.getName(), "CHICKEN NUGGET");
    }

    @Test
    public void testGetPrice(){
        MenuItem i = new MenuItem(MenuItem.itemType.BEVANDE, "COLA COLA", 3.50);
        assertEquals(i.getPrice(), 3.50, 1E-100);
    }
}
