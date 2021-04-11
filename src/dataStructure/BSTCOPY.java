package dataStructure;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/2/4
 * Describe:AVL树
 */
public class BSTCOPY<E extends Comparable<E>>{



    private class Node {
        private E e;

        private Node left;

        private Node right;

        private int height;

        public Node(E e) {
            this(e,null,null);
        }

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
            this.height = 1;
        }
    }

    private Node root;

    private int size;


    private Node right(Node y){
        Node x = y.left;
        Node T3 = x.right;
        y.left = T3;
        x.right = y;
        y.height= 1 + Math.max(getHeight(y.right), getHeight(y.left));
        x.height= 1 + Math.max(getHeight(x.right), getHeight(x.left));
        return x;
    }

    private Node left(Node y){
        Node x = y.right;
        Node T3 = x.left;
        y.right = T3;
        x.left = y;
        y.height= 1 + Math.max(getHeight(y.right), getHeight(y.left));
        x.height= 1 + Math.max(getHeight(x.right), getHeight(x.left));
        return x;
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public void add(E e) {
        root = add(root, e);
    }
    public Node add(Node node, E e) {
        if (node == null) {
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }
        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        if (e.compareTo(node.e) == 0) {
            node.e = e;
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        //判断该节点的平衡因子是否大于1  如果大于1 说明不平衡
        int balance = getBalanceFactor(node);
        // 需要平衡维护
        // 情况一 插入的节点在左子树的左子树
        if (balance > 1 && getBalanceFactor(node.left) >= 0) {
            return right(node);
        }
        //情况二 插入的节点在右子树的右子树
        if (balance < -1 && getBalanceFactor(node.right) <= 0) {
            return left(node);
        }
        //情况三 插入的节点在左子树的右子树
        if (balance > 1 && getBalanceFactor(node.left) < 0) {
            node.left = left(node.left);
            return right(node);
        }
        //情况四 插入的节点在右子树的左子树
        if (balance < -1 && getBalanceFactor(node.right) > 0) {
            node.right = right(node.right);
            return left(node);
        }
        return node;
    }
    private Node minmum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minmum(node.left);

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

    public void remove(E e) {
        root =  remove(root, e);
    }




    public Node remove(Node node, E e) {

        if (node == null) {
            return null;
        }
        Node retNode;
        if (node.e.compareTo(e) < 0) {
            node.left = remove(node.left, e);
            retNode = node;
        }
        if (node.e.compareTo(e) > 0) {
            node.right = remove(node.right, e);
            retNode = node;
        } else {
            if (node.left == null) {
                node=node.right;
                size--;
                retNode = node;
            }
            if (node.right == null) {
                node = node.left;
                size--;
                retNode = node;
            }
            Node minmum = minmum(node.right);
            Node node1 = removeMin(node.right);
            minmum.right = node1;
            minmum.left = node.left;
            node.left = node.right = null;
            retNode = minmum;
        }
        if (retNode == null) {
            return null;
        }
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
        //判断该节点的平衡因子是否大于1  如果大于1 说明不平衡
        int balance = getBalanceFactor(retNode);
        // 需要平衡维护
        // 情况一 插入的节点在左子树的左子树
        if (balance > 1 && getBalanceFactor(retNode.left) >= 0) {
            return right(retNode);
        }
        //情况二 插入的节点在右子树的右子树
        if (balance < -1 && getBalanceFactor(retNode.right) <= 0) {
            return left(retNode);
        }
        //情况三 插入的节点在左子树的右子树
        if (balance > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = left(retNode.left);
            return right(retNode);
        }
        //情况四 插入的节点在右子树的左子树
        if (balance < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = right(retNode.right);
            return left(retNode);
        }
        return retNode;

    }






}
