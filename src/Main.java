import customers.customer;
import products.expirableProduct;
import products.product;
import products.shippableProduct;
import products.simpleProduct;
import services.Checkout;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        shippableProduct tv = new shippableProduct("TV", 5000, 5, 7000);
        shippableProduct cheese = new shippableProduct("Cheese", 100, 10, 400);
        expirableProduct biscuits = new expirableProduct("Biscuits", 50, 20, LocalDate.now().plusDays(5));
        simpleProduct scratchCard = new simpleProduct("Scratch Card", 20, 100) {};


        customer c1 = new customer("Mohamed", 12000);


        c1.addToCart(tv, 2);
        c1.addToCart(cheese, 3);
        c1.addToCart(biscuits, 5);
        c1.addToCart(scratchCard, 4);


        Checkout checkoutService = new Checkout();
        checkoutService.checkout(c1);
    }
}