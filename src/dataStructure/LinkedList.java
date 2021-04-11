package dataStructure;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/2/4
 * Describe:
 */
public class LinkedList<E extends Comparable<E>> {


    private class Node{
        private E e;

        private Node next;

        public Node(E e, Node node) {
            this.e = e;
            this.next = node;
        }
        public Node(E e) {
            this(e,null);
        }
    }

    private Node head;

    public LinkedList() {
        head = new Node(null, null);
        size = 0;
    }

    private int size;
    public void add (E e) {
        add(size, e);
    }
    private void add(int index ,E e) {
        if (index < 0 && index > size) {
            throw new NullPointerException("不可以插入");
        }
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }


    private void remove(E e) {

        if (head.next != null) {
            Node node1 = head.next;
            if (node1.next != null) {
                while (!e.equals(node1.next.e)){
                    node1 = node1.next;
                }
                // node1.next.e  和e 是相等的，那么,就要删除node1.next这个节点
                node1.next = node1.next.next;
            }
        }

    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Node node = head;
        while (node != null) {
            stringBuffer.append(node.e).append(",");
            node = node.next;
        }
        return stringBuffer.toString();
    }


    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.add(1);
        integerLinkedList.add(5);
        integerLinkedList.add(3);
        integerLinkedList.add(2);

        System.out.println(integerLinkedList.toString());
        integerLinkedList.remove(1);
        System.out.println(integerLinkedList.toString());
    }



}
