package carts;

import products.product;

public class CartItem {
    private product product;
    private int quantity;

    public CartItem(product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public products.product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
