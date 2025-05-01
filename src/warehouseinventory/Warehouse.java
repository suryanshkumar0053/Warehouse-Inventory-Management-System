package warehouseinventory;

import java.time.LocalDate;
import java.util.*;

public class Warehouse {
    private Map<Integer, Product> productMap;   // Store products by ID
    private List<Product> productList;          // Maintain list of products for sequential access
    private ExpiryMinHeap expiryHeap;
    private InventoryBST inventoryBST;
    private QuantityBST quantityBST;
    private int idCounter;                     // Counter to track the last used product ID

    public Warehouse() {
        productMap = new HashMap<>();
        productList = new ArrayList<>();
        expiryHeap = new ExpiryMinHeap();
        inventoryBST = new InventoryBST();
        quantityBST = new QuantityBST();
        idCounter = 1; // Start ID from 1
    }

    public void addProduct(String name, int quantity, LocalDate expiryDate) {
        Product product = new Product(idCounter++, name, quantity, expiryDate); // Assign an incremented ID
        productMap.put(product.getId(), product);  // Store the product by ID
        productList.add(product);                   // Add to list for ordering
        expiryHeap.add(product);
        inventoryBST.insert(product);
        quantityBST.insert(product);
    }

    public Product getProductById(int id) {
        return productMap.get(id);
    }

    public Product getNextExpiringProduct() {
        return expiryHeap.getNextExpiring();
    }

    public List<Product> getSortedInventoryByName() {
        return inventoryBST.inorder();
    }

    public List<Product> getSortedInventoryByQuantity() {
        return quantityBST.inorder();
    }

    public void deleteProduct(int id) {
        Product product = productMap.get(id);
        if (product != null) {
            productMap.remove(id);
            productList.remove(product);
            expiryHeap = new ExpiryMinHeap(); // Recreate the heap to reset it
            inventoryBST = new InventoryBST(); // Recreate the tree to reset it
            quantityBST = new QuantityBST(); // Recreate the tree to reset it
            // Rebuild all collections after removal
            for (Product p : productList) {
                addProduct(p.getName(), p.getQuantity(), p.getExpiryDate());
            }
        }
    }
}
