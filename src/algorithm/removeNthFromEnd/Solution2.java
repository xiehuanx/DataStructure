package algorithm.removeNthFromEnd;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/4/13
 * Describe:
 */
public class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int traverse = traverse(head, n);
        if (traverse == n)
            return head.next;
        return head;
    }

    private int traverse(ListNode node, int n) {
        if (node == null)
            return 0;
        int num = traverse(node.next, n);
        if (num == n)
            node.next = node.next.next;
        return num + 1;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
