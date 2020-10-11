package avlTree;

import java.util.ArrayList;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2019/6/7
 * Time: 13:37
 * Describe:
 */
public class AVLTree<K extends Comparable<K>, V> {
    private class Node{
        public K key;
        public V value;
        public Node left, right;
        /**
         * 初始化时，任何一个子节点的高度都是1
         */
        public int height;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height=1;
        }
    }

    private Node root;
    private int size;

    public AVLTree(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 向二分搜索树中添加新的元素(key, value)
    public void add(K key, V value){
        root = add(root, key, value);
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

        // 向右旋转过程
        x.right = y;
        y.left = T3;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
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
        Node T2 = x.left;

        // 向左旋转过程
        x.left = y;
        y.right = T2;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    /**
     * 判断树是不是二分搜索树
     * 使用树的中序遍历  如果是二分搜索树的话，那么一定是从小到大排序的
     * @param node
     * @return
     */
    private boolean isBST(Node node){
        ArrayList<K> arrayList=new ArrayList<>();
        inOrder(node,arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i-1).compareTo(arrayList.get(i))>0){
                return false;
            }
        }
        return true;
    }

    /**
     * 判断树是否为平衡二叉树
     * 使用递归判断  每个节点的平衡因子的绝对值是否大于1 如果大于1 说明了树不是平衡二叉树
     * @param node
     * @return
     */
    private boolean isBalance(Node node){
        if (node==null) {
            return true;
        }
        int b=getBalanceFactor(node);
        if (Math.abs(b)>1){
            return false;
        }
        return isBalance(node.left)&&isBalance(node.right);
    }

    /**
     * 对树进行中序遍历  左中右
     * @param node
     * @param arrayList
     */
    private void inOrder(Node node,ArrayList<K> arrayList){
        if (node==null) {
            return;
        }
        inOrder(node.left,arrayList);
        arrayList.add(node.key);
        inOrder(node.right,arrayList);
    }

    /**
     * 私有方法   返回节点的高度
     * @param node
     * @return
     */
    private int getHeight(Node node){
        if (node==null) {
            return 0;
        }else {
            return node.height;
        }
    }

    /**
     * 计算node节点的平衡因子
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node){
        if (node==null){
            return 0;
        }
        return getHeight(node.left)-getHeight(node.right);
    }

    // 向以node为根的二分搜索树中插入元素(key, value)，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, K key, V value){

        if(node == null){
            size ++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        }
        else if(key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        }
        else {
            // key.compareTo(node.key) == 0
            node.value = value;
        }
        node.height=1+Math.max(getHeight(node.left),getHeight(node.right));
        //判断该节点的平衡因子是否大于1  如果大于1 说明不平衡
        int balance=getBalanceFactor(node);
        // 需要平衡维护
        // 情况一 插入的节点在左子树的左子树
        if (balance > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        //情况二 插入的节点在右子树的右子树
        if (balance < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        //情况三 插入的节点在左子树的右子树
        if (balance > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //情况四 插入的节点在右子树的左子树
        if (balance < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key){

        if(node == null) {
            return null;
        }

        if(key.equals(node.key)) {
            return node;
        }
        else if(key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        }
        else // if(key.compareTo(node.key) > 0){
            return getNode(node.right, key);
        }


    public boolean contains(K key){
        return getNode(root, key) != null;
    }

    public V get(K key){

        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除键为key的节点
    public V remove(K key){

        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){

        if( node == null )
            return null;
        Node retNode;
        if( key.compareTo(node.key) < 0 ){
            node.left = remove(node.left , key);
            retNode= node;
        }
        else if(key.compareTo(node.key) > 0 ){
            node.right = remove(node.right, key);
            retNode= node;
        }
        else{   // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                retNode= rightNode;
            } else if(node.right == null){
                // 待删除节点右子树为空的情况
                Node leftNode = node.left;
                node.left = null;
                size --;
                retNode= leftNode;
            } else {
                // 待删除节点左右子树均不为空的情况
                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = minimum(node.right);
                successor.right = remove(node.right,successor.key);
                successor.left = node.left;

                node.left = node.right = null;

                retNode= successor;
            }
        }
        if (retNode==null){
            return null;
        }
        retNode.height=1+Math.max(getHeight(retNode.left),getHeight(retNode.right));
        //判断该节点的平衡因子是否大于1  如果大于1 说明不平衡
        int balance=getBalanceFactor(retNode);
        // 需要平衡维护
        // 情况一 插入的节点在左子树的左子树
        if (balance > 1 && getBalanceFactor(retNode.left) >= 0) {
            return rightRotate(retNode);
        }
        //情况二 插入的节点在右子树的右子树
        if (balance < -1 && getBalanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }
        //情况三 插入的节点在左子树的右子树
        if (balance > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        //情况四 插入的节点在右子树的左子树
        if (balance < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        return retNode;
    }
}