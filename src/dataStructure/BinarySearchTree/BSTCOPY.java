package dataStructure.BinarySearchTree;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/2/3
 * Describe:
 */
public class BSTCOPY<E extends Comparable<E>> {


    private class Node {
        private E e;

        private Node left;

        private Node right;

        public Node(E e) {
            this(e,null,null);
        }

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    private int size;


    public void add(E e) {
        if (root == null) {
            root = new Node(e);
        }else {
            add(root,e);
        }
    }

    public void add(Node node, E e) {
        if (e.equals(node.e)) {
            return;
        }
        if (e.compareTo(node.e) > 0 && node.left == null) {
            node.right = new Node(e);
            size++;
            return;
        }
        if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        }
        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }

    public Node findMin(Node node) {
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }


    public Node removeMin(Node node){
        if (node.left == null) {
            node = node.right;
            size--;
            return node;
        }
        return node.left = removeMin(node.left);
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    public Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }

        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        else {
            // 相等 ，然后看左右子树是否为空，为空，和不为空，判断不同

            if (node.left == null) {
                node = node.right;
                size--;
                return node;
            }
            if (node.right == null) {
                node = node.left;
                size--;
                return node;
            }
            Node min = findMin(node.right);
            Node node1 = removeMin(node.right);
            min.right = node1;
            min.left = node.left;
            node.left = node.right = null;
            return min;

        }


    }


}
