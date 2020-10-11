package unionFind.UnionFind;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2019/3/31
 * Time: 20:38
 * Describe:
 */
public interface UF {
    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
