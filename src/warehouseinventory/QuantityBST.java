package warehouseinventory;

import java.util.ArrayList;
import java.util.List;

public class QuantityBST {
    private QuantityBSTNode root;

    public void insert(Product product) {
        root = insertRec(root, product);
    }

    private QuantityBSTNode insertRec(QuantityBSTNode node, Product product) {
        if (node == null) return new QuantityBSTNode(product);
        if (product.getQuantity() < node.product.getQuantity())
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

    private void inorderRec(QuantityBSTNode node, List<Product> list) {
        if (node != null) {
            inorderRec(node.left, list);
            list.add(node.product);
            inorderRec(node.right, list);
        }
    }
}

