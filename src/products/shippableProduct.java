package products;

import interfaces.IShippable;

public class shippableProduct extends product implements IShippable {

    private double weight;

    public shippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0.");
        }
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
