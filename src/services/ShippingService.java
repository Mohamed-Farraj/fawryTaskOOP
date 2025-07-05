package services;

import products.shippableProduct;

import java.util.List;

public class ShippingService {
        double totalWeight = 0;
    public double shipProducts(List<ShippingItem> items) {
        if (items.isEmpty()) {
            System.out.println("No items to ship.");
            return 0;
        }

        double totalWeight = 0;
        System.out.println("** Shipment notice **");

        for (ShippingItem item : items) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + (item.getProduct().getWeight() * item.getQuantity()) + "g");
            totalWeight += item.getProduct().getWeight() * item.getQuantity();
        }

        System.out.println("Total package weight " + totalWeight / 1000 + "kg");

        return (totalWeight / 1000) * 30;
    }
}
