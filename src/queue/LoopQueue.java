package queue;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2018/12/6
 * Time: 13:45
 * Describe: 循环队列
 * 给队首和队尾打标，当front==tail（即front和tail同时指向一个位置时，表示数组为空）
 * 循环队列需要浪费一个位置来标识队满的情况。当tail+1==front时，表示队满
 */
public class LoopQueue<E> implements Queue<E> {

    /**
     * 数据
     */
    private E[] data;
    /**
     * front 队首；tail 队尾
     */
    private int front, tail;
    /**
     *
     */
    private int size;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 推数据入栈，首先判断是否队满，如果队满，重新构建一个数组
     * （循环队列的队首和队尾会因为数据的增减而不断的移动，会导致队首和队尾的下标值超过数组的长度，所以这里的判断需要去模数组的长度，才会得到准确的数据）
     * 然后把数据添加给队尾
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 删除队首元素，然后把front指向下一个元素
     *
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        return null;
    }

    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++)
            newData[i] = data[(i + front) % data.length];

        data = newData;
        front = 0;
        tail = size;
    }

    public int getCapacity() {
        return data.length - 1;
    }
}
