public class BinarySearchTree<T> {

    class BSTNode { // binary search tree node
        Comparable data;
        BSTNode left;
        BSTNode right;

        public BSTNode(Comparable value) {
            data = value;
        }
    }

    private BSTNode root;

    public boolean find(Comparable value) {
        return find(root, value);
    }

    private boolean find(BSTNode node, Comparable value) {
        if (node == null) { // BASE CASE - if value is not in the search tree……. At this point we *could* insert something… look at insert()
            return false;
        }
        if (node.data.compareTo(value) == 0) {
            return true;
        } else if (node.data.compareTo(value) > 0) {
            return find(node.left, value);
        } else {
            return find(node.right, value);
        }
    }

    public void insert(Comparable value) {
        // call shadow function
        root = insert(root, value);
    }

    private BSTNode insert(BSTNode node, Comparable value) {
        if (node == null) {
            BSTNode newNode = new BSTNode(value);
            return newNode;
        } else if (node.data.compareTo(value) > 0) {
            // insert node on the right
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        return node;
    }

    public void delete(Comparable value) {
        root = delete(root, value);
    }

    private BSTNode delete(BSTNode node, Comparable value) {
        if (node == null) {
            return null;
        }
        if (node.data.compareTo(value) == 0) {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else { // the node has two children
                if (node.right.left == null) {
                    node.data = node.right.data; // take its data
                    node.right = node.right.right; // adopt its child
                    return node;
                } else {
                    node.data = removeSmallest(node.right); // on the right side
                    return node;
                }
            }
        } else if (node.data.compareTo(value) < 0) {
            node.left = delete(node.left, value); // .right may be a cause of error!    .data?
        } else {
            node.right = delete(node.right, value);
        }
        return node;
    }

    private Comparable removeSmallest(BSTNode node) {
        if (node.left.left == null) {  // you have found the smallest thing…
            Comparable smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        } else {
            return removeSmallest(node.left);
        }
    }

    public void print() {
        print(root);
    }

    private void print(BSTNode node) {
        if (node != null) {
            print(node.left);
            System.out.println(node.data);
            print(node.right);
        }
    }
}
