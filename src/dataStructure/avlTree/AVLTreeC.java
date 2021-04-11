package dataStructure.avlTree;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/2/3
 * Describe:
 */
public class AVLTreeC<K extends Comparable<K>, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        /**
         * 初始化时，任何一个子节点的高度都是1
         */
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }
    private Node root;
    private int size;

    public AVLTreeC() {
        root = null;
        size = 0;
    }


    /**
     * 获取
     * @param node  如果大于1，说明了左子树比右子树的高度 大1；如果小于-1，说明了右子树比左子树高度大于1
     * @return
     */
    public int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return node.left.height - node.right.height;
    }

    public void add(K k,V v) {
        root = add(root, k, v);
    }
    public Node add(Node node, K k,V v) {
        if (node == null) {
            size++;
            return new Node(k, v);
        }
        if (k.compareTo(node.key) < 0) {
            node.left = add(node.left, k ,v);
        }
        if (k.compareTo(node.key) > 0) {
            node.right = add(node.right, k ,v);
        }
        else {
            node.value = v;
        }
        node.height = Math.max(node.left.height,node.right.height) + 1;

        int balanceFactor = getBalanceFactor(node);

        return node;
    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        y.left = T3;
        x.right = y;

        y.height = Math.max(y.right.height,y.left.height) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }
    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T3 = x.left;
        y.right = T3;
        x.left = y;
        y.height = Math.max(y.right.height,y.left.height) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }




}
