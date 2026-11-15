package footballmanagementsystem;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(String data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, String data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data.compareTo(root.info) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.info) > 0) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public boolean search(String data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, String data) {
        if (root == null) {
            return false;
        }
        if (data.equals(root.info)) {
            return true;
        }
        if (data.compareTo(root.info) < 0) {
            return searchRec(root.left, data);
        }
        return searchRec(root.right, data);
    }

    public void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.info + " ");
            printInorder(root.right);
        }
    }
}