package segmentTree;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2018/12/29
 * Time: 16:27
 * Describe:
 */
public interface Merger<E> {
    E merge(E a, E b);
}
