package stack;

import array.Array;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2018/12/5
 * Time: 22:11
 * Describe:
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> data;


    public ArrayStack(int capacity){
        data=new Array<>(capacity);
    }
    public ArrayStack(){
        data=new Array<>();
    }


    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void push(E e) {
        data.add(e);
    }

    @Override
    public E pop() {
        return data.remove(data.getSize()-1);
    }

    @Override
    public E peek() {
        return data.get(data.getSize()-1);
    }
}
