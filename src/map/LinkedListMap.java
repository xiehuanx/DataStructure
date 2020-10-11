package map;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2018/12/17
 * Time: 22:22
 * Describe:
 */
public class LinkedListMap<K, V> implements Map<K, V>  {

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value){
            this(key, value, null);
        }

        public Node(){
            this(null, null, null);
        }

        @Override
        public String toString(){
            return key.toString() + " : " + value.toString();
        }
    }
    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    private Node getNode(K key){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.key.equals(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {

    }

    @Override
    public V remove(K key) {
        Node prev=dummyHead.next;
        while (prev!=null){
            if (prev.key.equals(key)){
                break;
            }
            prev=prev.next;
        }
        if (prev!=null){
            Node delNode = prev;
            prev = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;

        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        Node node = getNode(key);
        if (node==null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public V get(K key) {
        return getNode(key).value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node==null){
            dummyHead.next=new Node(key,newValue,dummyHead.next);
            size++;
        }else{
            node.value=newValue;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
