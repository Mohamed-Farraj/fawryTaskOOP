package products;

import java.time.LocalDate;

public class simpleProduct extends product{
    public simpleProduct(String name, double price, int quantity , LocalDate expirationDate) {
        super(name, price, quantity);
    }

}
