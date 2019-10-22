public class BST<T>  {

    Node root;

    public BST() {
        root = null;
    }

    class Node {
        private Comparable data;
        private int instanceOfData;
        private Node left;
        private Node right;

        Node(Comparable data) {
            this.data = data;
            this.instanceOfData = 1;
            this.left = null;
            this.right = null;
        }
    }

    boolean find(Comparable target) {
        return find(target, root);
    }

    void print() {
        print(root);
    }

    void print(Node node) {
       if(node == null) {
           return;
       }
       print(node.right);
       System.out.println(node.data);
       print(node.left);
    }

    boolean find(Comparable target, Node node) {
        if(node == null)
            return false;
        if(target == node.data)
            return true;
        if(node.data.compareTo(target) < 0)
            return find(target, node.left);
        else
            return find(target, node.right);
    }

    void insert(Comparable item) {
        root = insert(item, root);
    }

    Node insert(Comparable item, Node node) {
        if(node == null)
            return new Node(item);
        if(item == node.data) {
            node.instanceOfData++;
            return node;
        }
        if(node.data.compareTo(item) < 0) {
            node.left = insert(item, node.left);
            return node;
        }
        else {
            node.right = insert(item, node.right);
            return node;
        }
    }

    void delete(Comparable item) {
        root = delete(root, item);
    }

    Node delete(Node node, Comparable item) {
        if (node == null)
            return null;
        if (node.data == item) {
            node.instanceOfData--;
            if(node.instanceOfData > 0)
                return node;
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;
            if (node.right.left == null) {
                node.data = node.right.data;
                node.right = node.right.right;
                return node;
            } else {
                node.data = remove_smallest(node.right);
                return node;
            }
        }
            if (node.data.compareTo(item) < 0) {
                node.right = delete(node.right, item);
                return node;
            } else {
                node.left = delete(node.left, item);
                return node;
            }
        }

    Comparable remove_smallest(Node node) {
        if(node.left.left == null) {
            Comparable smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        } else {
            return remove_smallest(node.left);
        }
    }
}
