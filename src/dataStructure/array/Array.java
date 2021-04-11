package dataStructure.array;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2018/12/4
 * Time: 14:41
 * Describe:动态数组，自动变化长度
 */
public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 传入长度的构造函数
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 默认构造函数，默认长度为10
     */
    public Array() {
        this(10);
    }

    /**
     * 将一个数组转化成一个Array
     *
     * @param arr
     */
    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /**
     * 获取数组中元素的个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的长度
     *
     * @return
     */
    public int getLength() {
        return data.length;
    }

    /**
     * 数组是否为空，即size是否为0
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在指定位置插入一个元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        //因为数组的特性，向指定位置插入一个元素，需要把这个位置后面的元素整体向后移动一个位置
        //如果直接赋值，会覆盖掉原index位置的数据，导致数据丢失
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }


    /**
     * 向数组的size位置添加一个元素
     *
     * @param e
     */
    public void addLast(E e) {
        int index = size;
        add(index, e);
    }

    /**
     * 向数组的size位置添加一个元素
     *
     * @param e
     */
    public void add(E e) {
        int index = size;
        add(index, e);
    }

    /**
     * 在数组的首位添加一个元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 获取指定位置的数据
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed. Require index >= 0 and index <= size.");
        }
        return data[index];
    }

    /**
     * 更新指定位置的数据
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed. Require index >= 0 and index <= size.");
        }
        data[index] = e;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        // loitering objects != memory leak
        data[size] = null;

        if (size == data.length / 4) {
            resize(data.length / 2);
        }
        return ret;
    }


    /**
     * 将数组空间的容量变成newCapacity大小
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 交换索引i和j的数据
     *
     * @param i
     * @param j
     */
    public void swap(int i, int j) {

        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
