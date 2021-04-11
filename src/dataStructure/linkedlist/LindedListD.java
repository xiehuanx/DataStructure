package dataStructure.linkedlist;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/2/1
 * Describe:
 */
public class LindedListD<E> {

    private class Node {

        private E data;

        private Node next;

        public Node(E data){
            this(data, null);
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;

    private int size;

    public void  add(int index, E data) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node=new Node(data);
        node.next=prev.next;
        prev.next=node;
        size ++;
    }
    public void  add(E data) {
        add(size,data );
    }

    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer = toString(head, stringBuffer);
        return stringBuffer.toString();
    }

    private StringBuffer toString(Node node, StringBuffer stringBuffer){
        if (node.next == null && node != null) {
            return stringBuffer.append(node.data).append(",");
        }
        return toString(node.next, stringBuffer);
    }




}
