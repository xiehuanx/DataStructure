package dataStructure.set;

import dataStructure.BinarySearchTree.BST;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2018/12/16
 * Time: 16:48
 * Describe:
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        boolean contains = bst.contains(e);
        return contains;
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
