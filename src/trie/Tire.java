package trie;

import java.util.TreeMap;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2019/1/8
 * Time: 20:25
 * Describe:字典树
 * 这里设置只可以添加字母
 */
public class Tire {

    private class Node{
        private boolean isword;
        private TreeMap<Character,Node> next;
        public Node(boolean isword){
            this.isword=isword;
            next=new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public Tire(){
        root=new Node();
        size=0;
    }

    public int getSize(){
        return size;
    }

    /**
     * add方法，添加一个字符串
     * @param word
     */
    public void add(String word){
        Node cur=root;
        for (int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if(!cur.isword){
            cur.isword = true;
            size ++;
        }
    }

    /**
     * 树中是否包含字符串
     * @param word
     * @return
     */
    public boolean contain(String word){
        Node cur=root;
        for (int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isword;
    }

    /**
     * 查询是否在Trie中有单词以prefix为前缀
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix){

        Node cur = root;
        for(int i = 0 ; i < prefix.length() ; i ++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }

        return true;
    }

}
