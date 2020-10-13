package BinarySearchTree;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2018/12/13
 * Time: 14:33
 * Describe:binary ssearch tree
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 1.首先去看节点是否为空，如果为空，直接插入根节点的e中，否则就去和节点的元素e进行比较
     * 2.如果和节点的元素相等，直接返回，不执行其他操作，
     * 3.如果比节点e小，并且节点左子树为空，直接插入节点左子树
     * 4.如果比节点eda，并且节点右子树为空，直接插入节点右子树
     * 5.如果比节点e小，并且节点左子树不为空，那么就把现在的node和e，继续代入2，3，4，5，6
     * 6.如果比节点e大，并且节点右子树不为空，那么就把现在的node和e，继续代入2，3，4，5，6
     *
     * @param e
     */
    public void addBase(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            addBase(root, e);
        }
    }

    /**
     * 添加元素
     *
     * @param node
     * @param e
     */
    private void addBase(Node node, E e) {
        //与节点的元素进行比较，看是否相等，如果相等，就不继续执行下去，
        if (e.equals(node.e)) {
            return;
        }
        //与节点的元素进行比较，看是否小于节点，
        if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        }
        //与节点的元素进行比较，看是否大于节点，
        if (e.compareTo(node.e) > 0 && node.left == null) {
            node.right = new Node(e);
            size++;
            return;
        }
        if (e.compareTo(node.e) < 0) {
            addBase(node.left, e);
        } else {
            addBase(node.right, e);
        }


    }

    /**
     * 改进原版代码
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        //与节点的元素进行比较，看是否相等，如果相等，就不继续执行下去，
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 元素e是否存在与树中
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        boolean contains = contains(root, e);
        return contains;
    }

    public boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        }
        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历
     * 1）访问根节点
     * 2）前序遍历左子树
     * 3）前序遍历右子树
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     * （1）中序遍历左子树
     * （2）访问根节点
     * （3）中序遍历右子树
     */
    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        System.out.println(node.e);
        preOrder(node.right);
    }

    /**
     * 后序遍历：
     * （1）后序遍历左子树
     * （2）后序遍历右子树
     * （3）访问根节点
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.e);
    }

    /**
     * 查找最小值
     *
     * @return
     */
    public E minmum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("node is null");
        }
        Node minmum = minmum(root);
        return minmum.e;

    }

    private Node minmum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minmum(node.left);

    }

    /**
     * 查找最大值
     *
     * @returnax
     */
    public E maxmum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("node is null");
        }
        Node maxmum = maxmum(root);
        return maxmum.e;

    }

    private Node maxmum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxmum(node.right);

    }

    /**
     * 删除链表的最小值
     *
     * @return
     */
    public E removeMin() {
        E ret = minmum();
        root = removeMin(root);
        return ret;

    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            node = node.right;
            size--;
            return node;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除链表的最max值
     *
     * @return
     */
    public E removeMax() {
        E ret = minmum();
        root = removeMax(root);
        return ret;

    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            node = node.left;
            size--;
            return node;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 使用待删除元素的后继来完成删除操作
     *
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (node.e.compareTo(e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        if (node.e.compareTo(e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
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

            Node minmum = minmum(node.right);
            Node node1 = removeMin(node.right);
            minmum.right = node1;
            minmum.left = node.left;
            node.left = node.right = null;
            return minmum;
        }
    }

    /**
     * 使用前驱来进行数据的删除
     *
     * @param e
     */
    public void removePredecessor(E e) {
        root = removePredecessor(root, e);
    }

    private Node removePredecessor(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (node.e.compareTo(e) < 0) {
            node.left = removePredecessor(node.left, e);
            return node;
        }
        if (node.e.compareTo(e) > 0) {
            node.right = removePredecessor(node.right, e);
            return node;
        } else {
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
            Node maxmum = maxmum(node.right);
            Node node1 = removeMax(node.right);
            maxmum.right = node1;
            maxmum.left = node.left;
            node.left = node.right = null;
            return maxmum;
        }


    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth));
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        return res.toString();
    }


}
