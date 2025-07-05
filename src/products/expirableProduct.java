package products;

import interfaces.IExpireable;

import java.time.LocalDate;

public class expirableProduct extends product implements IExpireable {
   private LocalDate expirationDate;

    public expirableProduct(String name, double price, int quantity ,LocalDate expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;

        if (expirationDate == null) {
            throw new IllegalArgumentException("expiration cannot be null");
        }

    }


    @Override
    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }
}
