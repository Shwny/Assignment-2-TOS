//Giacomo Bulbarelli 1144046
package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import java.util.List;

public class BillMaker implements TakeAwayBill {


    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {

        double totalPrice=0;

        totalPrice = itemsOrdered.stream().mapToDouble(MenuItem::getPrice).sum();

        return totalPrice;
    }

}
