package warehouseinventory;

import java.time.LocalDate;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private LocalDate expiryDate;

    public Product(int id, String name, int quantity, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public LocalDate getExpiryDate() { return expiryDate; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Qty: " + quantity + ", Expiry: " + expiryDate;
    }
}
