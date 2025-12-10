package pgdp.upa;

public class Item {

    private String kind;
    private int price;

    private static int mostExpensive = 0;

    public Item(String kind) {
        this.kind = kind;
        this.price = 0;
    }

    public void setPrice(int price) {
        this.price = price;
        if (price > mostExpensive) {
            mostExpensive = price;
        }
    }

    public int getPrice() {
        return price;
    }

    public static int getMostExpensivePrice() {
        return mostExpensive;
    }

    public String getKind() {
        return kind;
    }

    public String toString() {
        return "Item " + kind + " costs " + price;
    }
}
