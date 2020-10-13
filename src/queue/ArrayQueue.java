package queue;

import array.Array;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2018/12/5
 * Time: 22:34
 * Describe:
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.add(e);
    }

    @Override
    public E dequeue() {
        return array.remove(0);
    }

    @Override
    public E getFront() {
        return array.get(0);
    }
}
