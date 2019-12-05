package it.unipd.tos;

import it.unipd.tos.model.MenuItem;
import static org.junit.Assert.assertEquals;

public class MenuItemTest {

    @org.junit.Test
    public void testGetType(){
        MenuItem i = new MenuItem(MenuItem.itemType.PANINI, "CHEESEBURGER", 5.00);
        assertEquals(i.getType(), MenuItem.itemType.PANINI);
    }

    @org.junit.Test
    public void testGetName(){
        MenuItem i = new MenuItem(MenuItem.itemType.FRITTI, "CHICKEN NUGGET", 4.00);
        assertEquals(i.getName(), "CHEESEBURGER");
    }

    @org.junit.Test
    public void testGetPrice(){
        MenuItem i = new MenuItem(MenuItem.itemType.BEVANDE, "COLA COLA", 3.50);
        assertEquals(i.getPrice(), 3.50, 1E-10);
    }
}
