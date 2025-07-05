package products;

public abstract class product {
    private String name;
    private double price;
    private int quantity;

    public product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getQuantity(){
        return this.quantity;
    }
}
