package it.unipd.tos;

import it.unipd.tos.business.BillMaker;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BillMakerTest {

    @Test
    public void testScontoCinquePanini(){
        List<MenuItem> i = new ArrayList<>();
        for(int count = 0; count < 5; count++){
            i.add(new MenuItem(MenuItem.itemType.PANINI, "CHEESEBURGER", 5));
        }

        i.add(new MenuItem(MenuItem.itemType.PANINI, "PANE E SALAME", 4));

        BillMaker make = new BillMaker();
        double tp = 0;
        try {
            tp = make.getOrderPrice(i);
        }catch(TakeAwayBillException e){
            System.out.println("Error");
        }
        assertEquals(tp, 27 , 1E-100);
    }

    @Test
    public void testPriceSenzaSconti() {
        List<MenuItem> i = new ArrayList<>();
        for(int count=0; count < 5; count++){
            i.add(new MenuItem(MenuItem.itemType.PANINI, "CHEESEBURGER", 5));
        }

        BillMaker make = new BillMaker();
        double tp = 0;

        try {
            tp = make.getOrderPrice(i);
        } catch (TakeAwayBillException error) {
            System.out.println("Error");
        }
        assertEquals(tp, 25, 1E-100);
    }

    @Test
    public void testScontoPaninieFritti() {
        List<MenuItem> i = new ArrayList<>();
        for(int count=0; count < 5; count++){
            i.add(new MenuItem(MenuItem.itemType.FRITTI, "FRITTO MISTO", 10));
        }

        i.add(new MenuItem(MenuItem.itemType.PANINI, "CHEESEBURGER", 5));

        i.add(new MenuItem(MenuItem.itemType.BEVANDE, "COLA COLA", 2.50));

        BillMaker make = new BillMaker();
        double tp = 0;

        try {
            tp = make.getOrderPrice(i);
        } catch (TakeAwayBillException error) {
            System.out.println("Error");
        }
        assertEquals(tp, 51.75, 1E-100);
    }

    @Test(expected = TakeAwayBillException.class)
    public void testTroppiOrdiniException() throws TakeAwayBillException{
        List<MenuItem> i = new ArrayList<>();
        for(int count = 0; count < 35; count++) {
            i.add(new MenuItem(MenuItem.itemType.PANINI, "CHEESEBURGER", 5.00));
        }
        BillMaker make = new BillMaker();
        make.getOrderPrice(i);
    }

    @Test
    public void testMenoDiDieciEuro() {
        List<MenuItem> i = new ArrayList<>();
        i.add(new MenuItem(MenuItem.itemType.PANINI, "CHEESEBURGER", 5.00));
        BillMaker make = new BillMaker();

        double tp = 0;

        try {
            tp = make.getOrderPrice(i);
        } catch (TakeAwayBillException error) {
            System.out.println("Error");
        }

        assertEquals(tp, 5.50, 1E-100);
    }

}
