package heap;

import array.Array;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2018/12/19
 * Time: 21:40
 * Describe:最大堆
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    public MaxHeap(E[] es){
        data = new Array<>(es);
        for(int i = parent(es.length - 1) ; i >= 0 ; i --){
            siftDown(i);
        }

    }

    /**
     * 返回堆中的元素个数
     * @return
     */
    public int size(){
        return data.getSize();
    }

    /**
     *返回一个布尔值, 表示堆中是否为空
     * @return
     */
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的中，一个索引所表示元素的父节点
     * @param index
     * @return
     */
    private int parent(int index){
        if (index==0){
            throw new IllegalArgumentException();
        }
        return (index-1)/2;
    }

    /**
     *  返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index){
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     * @param e
     */
    public void add(E e){
        data.add(e);
        siftUp(data.getSize()-1);
    }

    /**
     * 上浮元素
     * 向数组的最后一个位置添加元素，然后查看添加的元素是否大于它的父节点，
     * 如果大于父节点，就要把这个元素与父节点上浮，即与父节点进行位置交换
     * @param i
     */
    private void siftUp(int i) {
        while (i>0&&data.get(parent(i)).compareTo(data.get(i))<0){
                data.swap(i,parent(i));
                i=parent(i);
        }
    }
    public E findMax(){
        if (data.isEmpty()){
            throw new IllegalArgumentException();
        }
        return data.get(0);
    }

    /**
     * 删除最大值
     * @return
     */
    public E extractMax(){
        E ret=findMax();
        data.swap(0,data.getSize()-1);
        data.remove(data.getSize()-1);
        siftDown(0);
        return ret;
    }

    /**
     * 下沉操作
     * 与子节点进行比较，与大的子节点进行位置的交换
     * @param i
     */
    private void siftDown(int i) {
        while (leftChild(i)<data.getSize()){

            int leftChild = leftChild(i);
            if (leftChild+1<data.getSize()&&data.get(leftChild+1).compareTo(data.get(leftChild))>0){
                leftChild=rightChild(i);
            }
            if (data.get(i).compareTo(data.get(leftChild))>=0){
                break;
            }
            data.swap(i,leftChild);
            i=leftChild;

        }
    }

    /**
     * 将堆中的最大元素替换
     * @param e
     * @return
     */
    public E replaceMax(E e){
        E max = findMax();
        data.set(0,e);
        siftDown(0);
        return max;
    }


}
