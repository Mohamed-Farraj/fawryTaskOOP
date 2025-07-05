package carts;

import products.product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items;

    public Cart()
    {
        this.items = new ArrayList<>();
    }

    public void addProduct(product myProduct, int quantity)
    {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be valid.");
        }
        if (quantity > myProduct.getQuantity()) {
            throw new IllegalArgumentException("Not enough stock available for this product: ");
        }

        // Check if myProduct already in cart
        for (CartItem item : items) {
            if (item.getProduct().equals(myProduct)) {
                int newQuantity = item.getQuantity() + quantity;
                if (newQuantity > myProduct.getQuantity()) {
                    throw new IllegalArgumentException("Not enough stock available for this product");
                }
                items.remove(item);
                items.add(new CartItem(myProduct, newQuantity));
                return;
            }
        }

        items.add(new CartItem(myProduct, quantity));



    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
