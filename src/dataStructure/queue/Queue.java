package dataStructure.queue;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2018/12/5
 * Time: 22:25
 * Describe: dataStructure.queue.Queue,first in,first out
 */
public interface Queue<E> {
    /**
     * 获取size
     *
     * @return
     */
    int getSize();

    /**
     * 是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 压数据进行队列
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 删除队列第一个元素
     *
     * @return
     */
    E dequeue();

    /**
     * 返回队列第一个元素，不进行删除
     *
     * @return
     */
    E getFront();
}
