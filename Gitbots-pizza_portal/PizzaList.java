
public class PizzaList {
    String pizzaName;
    int price;
    String pSize;
    public PizzaList(String pizzaName, int price,String s) {
        super();
        this.pizzaName = pizzaName;
        this.price = price;
        this.pSize=s;
    }

    @Override
    public String toString() {
        return "" +pSize  + "  " + pizzaName + "    " + price + " ";
    }

}