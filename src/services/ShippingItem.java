package services;

import interfaces.IShippable;

public class ShippingItem {
    private IShippable product;
    private int quantity;

    public ShippingItem(IShippable product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public IShippable getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
