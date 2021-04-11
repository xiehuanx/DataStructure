package dataStructure;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/2/4
 * Describe:
 */
public class MaxHeap <E extends Comparable<E>>{

    private ArrayList<E> arrayList;

    private int size;

    /**
     * 获取父节点
     * @param ch
     * @return
     */
    public int getParent(int ch) {
        return (ch - 1)-1;
    }

    public void add(E e){
        arrayList.add(e);
        siftUp(arrayList.size() - 1);
    }
    public void siftUp(int index) {
        while ( index > 0 && arrayList.get(index).compareTo(arrayList.get(getParent(index))) > 0) {
            E e = arrayList.get(index);
            arrayList.set(index, arrayList.get(getParent(index)));
            arrayList.set(index, e);
            index = getParent(index);
        }
    }


}
