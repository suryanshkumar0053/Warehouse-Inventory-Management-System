package warehouseinventory;

import java.util.ArrayList;
import java.util.List;

public class InventoryBST {
    private BSTNode root;

    public void insert(Product product) {
        root = insertRec(root, product);
    }

    private BSTNode insertRec(BSTNode node, Product product) {
        if (node == null) return new BSTNode(product);
        if (product.getName().compareToIgnoreCase(node.product.getName()) < 0)
            node.left = insertRec(node.left, product);
        else
            node.right = insertRec(node.right, product);
        return node;
    }

    public List<Product> inorder() {
        List<Product> list = new ArrayList<>();
        inorderRec(root, list);
        return list;
    }

    private void inorderRec(BSTNode node, List<Product> list) {
        if (node != null) {
            inorderRec(node.left, list);
            list.add(node.product);
            inorderRec(node.right, list);
        }
    }
}


