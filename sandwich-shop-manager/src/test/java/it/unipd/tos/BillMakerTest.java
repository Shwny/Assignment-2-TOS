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
    public void TestPrice() {
        List<MenuItem> i = new ArrayList<>();
        for(int count=0; count < 10; count++){
            i.add(new MenuItem(MenuItem.itemType.PANINI, "CHEESEBURGER", 5));
        }

        BillMaker make = new BillMaker();
        double tp = 0;

        try {
            tp = make.getOrderPrice(i);
        } catch (TakeAwayBillException error) {
            System.out.println("Error");
        }
        assertEquals(tp, 50, 1E-100);
    }

}
