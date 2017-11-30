package ShoppingCart;

public class Item {
    private String name;
    private int quantaty;
    private double price;

    public Item(String name, int quantaty, double price) {
        this.name = name;
        this.quantaty = quantaty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantaty() {
        return quantaty;
    }

    public void setQuantaty(int quantaty) {
        this.quantaty = quantaty;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }


}
