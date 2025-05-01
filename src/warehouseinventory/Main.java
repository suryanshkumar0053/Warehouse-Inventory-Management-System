package warehouseinventory;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nWarehouse Inventory System");
            System.out.println("1. Add Product");
            System.out.println("2. View Product by ID");
            System.out.println("3. View Next Expiring Product");
            System.out.println("4. View Inventory Sorted by Name");
            System.out.println("5. View Inventory Sorted by Quantity");
            System.out.println("6. Delete Product");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Expiry (YYYY-MM-DD): ");
                    String date = scanner.next();
                    LocalDate expiry = LocalDate.parse(date);
                    warehouse.addProduct(name, qty, expiry);
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    Product product = warehouse.getProductById(scanner.nextInt());
                    System.out.println(product != null ? product : "Not Found");
                    break;

                case 3:
                    Product next = warehouse.getNextExpiringProduct();
                    System.out.println(next != null ? next : "No products");
                    break;

                case 4:
                    for (Product p : warehouse.getSortedInventoryByName()) {
                        System.out.println(p);
                    }
                    break;

                case 5:
                    for (Product p : warehouse.getSortedInventoryByQuantity()) {
                        System.out.println(p);
                    }
                    break;

                case 6:
                    System.out.print("Enter ID of product to delete: ");
                    int idToDelete = scanner.nextInt();
                    warehouse.deleteProduct(idToDelete);
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        scanner.close();
    }
}