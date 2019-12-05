////////////////////////////////////////////////////////////////////
// [Giacomo] [Bulbarelli] [11440460]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {

    public enum itemType {PANINI, FRITTI, BEVANDE};

    private itemType type;
    private String name;
    private double price;

    public MenuItem(itemType i, String n, double p ) {
        this.type=i;
        this.name=n;
        this.price=p;
    }

    public itemType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
