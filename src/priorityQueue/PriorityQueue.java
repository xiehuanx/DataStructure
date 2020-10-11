package priorityQueue;

import heap.MaxHeap;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2018/12/24
 * Time: 23:25
 * Describe:
 */
public class PriorityQueue<E extends  Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
