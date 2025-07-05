package services;

import carts.Cart;
import carts.CartItem;
import customers.customer;
import interfaces.IExpireable;
import interfaces.IShippable;
import products.product;
import products.shippableProduct;

import java.util.ArrayList;
import java.util.List;

public class Checkout {
    private ShippingService shippingService = new ShippingService();
    List<shippableProduct> shippableProducts = new ArrayList<>();

    public void checkout(customer customer) {

        Cart cart = customer.getCustomerCart();

        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        double subtotal = 0;
        List<ShippingItem> shippableItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            product product = item.getProduct();

            if (product instanceof IExpireable expirableProduct) {
                if (expirableProduct.isExpired()) {
                    throw new IllegalStateException(" there is expired Product.");
                }
            }

            if (item.getQuantity() > product.getQuantity()) {
                throw new IllegalStateException("Not enough stock for product: " + product.getName());
            }

            subtotal += product.getPrice() * item.getQuantity();

            if (product instanceof IShippable shippableProduct) {
                shippableItems.add(new ShippingItem(shippableProduct, item.getQuantity()));
            }
        }

        double shippingFees = 0;
        if (!shippableItems.isEmpty()) {
            shippingFees = shippingService.shipProducts(shippableItems);
        }

        double totalAmount = subtotal + shippingFees;

        if (totalAmount > customer.getBalance()) {
            throw new IllegalStateException("Insufficient balance.");
        }

        customer.withdraw(totalAmount);

        for (CartItem item : cart.getItems()) {
            product product = item.getProduct();
            product.setQuantity(product.getQuantity() - item.getQuantity());
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + (item.getProduct().getPrice() * item.getQuantity()));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shippingFees);
        System.out.println("Total amount: " + totalAmount);
        System.out.println("Customer balance after payment: " + customer.getBalance());
    }
}
