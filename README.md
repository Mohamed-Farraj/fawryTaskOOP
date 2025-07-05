# E-Commerce System - Internship Task

##  Project Overview

This is a simple console-based e-commerce system designed as part of a Full Stack Development Internship challenge. The system allows customers to:

- Define products (shippable, expirable, or both)
- Add products to their cart with quantity checks
- Checkout with full validation
- Calculate shipping fees for shippable items
- Handle expired products and stock limitations
- Print checkout details and shipping notice

---

## 🛠 Tech Stack

- Java 17+
- Object-Oriented Design
- Interfaces (`IShippable`, `IExpireable`)
- Console-based interaction

---


##  How to Run

1. Open the project in your Java IDE (IntelliJ, Eclipse, VSCode, etc.)
2. Run the `Main.java` class
3. Console output will display shipping details and checkout receipt

---

##  System Features

- **Product Types:**

  - Shippable Products (e.g., TV, Cheese)
  - Expirable Products (e.g., Biscuits)
  - Products that can be both shippable and expirable
  - Basic Products (e.g., Scratch Card)

- **Cart Operations:**

  - Add product to cart (quantity cannot exceed stock)
  - Automatic cart creation per customer

- **Checkout Validation:**

  - Throws error if cart is empty
  - Throws error if product is expired
  - Throws error if stock is insufficient
  - Throws error if customer balance is insufficient
  - Deducts product quantities after successful checkout
  - Deducts customer balance
  - Calculates shipping fees for shippable products (30 EGP per kg)

---

## Assumptions

- Expired products are not allowed in checkout.
- Only products implementing `IShippable` interface contribute to shipping fees.
- Products quantities are updated after successful checkout.
- Customer's cart is owned privately inside the `customer` class.

---


## Developed for Internship Task

*Designed with clean OOP principles & extensibility in mind*

