package stack;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2018/12/5
 * Time: 22:06
 * Describe: 栈的接口，先进后出
 */
public interface Stack<E> {
    /**
     * 获取size
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 推入栈，把数据压入栈顶，相当于add
     * @param e
     */
    void push(E e);

    /**
     * 删除栈顶元素，相当于remove
     * @return
     */
    E pop();

    /**
     * 返回栈顶元素，并不进行删除
     * @return
     */
    E peek();
}
