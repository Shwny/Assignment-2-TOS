//Giacomo Bulbarelli 1144046
package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import java.util.List;

public class BillMaker implements TakeAwayBill {


    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {

        double totalPrice=0;

        totalPrice = itemsOrdered.stream().mapToDouble(MenuItem::getPrice).sum();

        if(itemsOrdered.stream().filter(x -> x.getType() == MenuItem.itemType.PANINI).count() > 5){
            totalPrice -= 0.5 * itemsOrdered
                    .stream().filter(x -> x.getType() == MenuItem.itemType.PANINI)
                    .mapToDouble(MenuItem::getPrice).min().getAsDouble();
        }

        return totalPrice;
    }

}
