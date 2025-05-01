package warehouseinventory;

import java.util.PriorityQueue;

public class ExpiryMinHeap {
    private PriorityQueue<Product> minHeap;

    public ExpiryMinHeap() {
        minHeap = new PriorityQueue<>((a, b) -> a.getExpiryDate().compareTo(b.getExpiryDate()));
    }

    public void add(Product product) {
        minHeap.offer(product);
    }

    public Product getNextExpiring() {
        return minHeap.peek();
    }
}


