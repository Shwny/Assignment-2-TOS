//Giacomo Bulbarelli 1144046
package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import java.util.List;

public class BillMaker implements TakeAwayBill {


    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {

        double totalPrice=0;

        if(itemsOrdered.size() > 30){
            throw new TakeAwayBillException("Effettuato ordine troppo grande");
        }

        totalPrice = itemsOrdered.stream().mapToDouble(MenuItem::getPrice).sum();

        if(itemsOrdered.stream().filter(x -> x.getType() == MenuItem.itemType.PANINI).count() > 5){
            totalPrice -= 0.5 * itemsOrdered
                    .stream().filter(x -> x.getType() == MenuItem.itemType.PANINI)
                    .mapToDouble(MenuItem::getPrice).min().getAsDouble();
        }

        double pricePanini = 0;
        double priceFritti = 0;

        pricePanini += itemsOrdered
                .stream().filter(x -> x.getType() == MenuItem.itemType.PANINI)
                .map(MenuItem::getPrice).reduce(0.0, Double::sum);

        priceFritti += itemsOrdered
                .stream().filter(x -> x.getType() == MenuItem.itemType.FRITTI)
                .map(MenuItem::getPrice).reduce(0.0, Double::sum);

        if(priceFritti+pricePanini > 50){
            totalPrice -= 0.1*totalPrice;
        }

        return totalPrice;
    }

}
