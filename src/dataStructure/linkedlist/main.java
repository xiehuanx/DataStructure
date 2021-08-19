package dataStructure.linkedlist;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/8/19
 * Describe:
 */
public class main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        LinkedList<Integer>.Node reversal = linkedList.reversal();

        System.out.println(reversal);

    }
}
