package customers;
import carts.Cart;
import products.product;

public class customer {
    private String name;
    private double balance;
    private Cart customerCart;

    public customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.customerCart = new Cart();  // كل عميل بياخد كارت خاص بيه
    }

    public void addbalance(double value)
    {
        this.balance += value;
    }

    public void withdraw(double value) {
        if (value > this.balance)
        this.balance -= value;

        else
            throw new IllegalArgumentException("Insufficient balance.");

    }

    public void addToCart(product product, int quantity) {
        this.customerCart.addProduct(product, quantity);
    }



}
