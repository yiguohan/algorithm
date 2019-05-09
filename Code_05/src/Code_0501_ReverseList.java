/**
 * * 分别实现反转单项链表和反转双向链表的方法
 * * 要求：
 * * 如果链表长度为N
 * * 时间复杂度O(N)
 * * 额外空间复杂度O(1)
 */
public class Code_0501_ReverseList {

    //-------------------------------------反转单链表--------------------------------------//
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node reverseList(Node head) {
        Node next = null;
        Node pre = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //-------------------------------------反转双向链表--------------------------------------//
    public static class DoubleNode {
        int val;
        DoubleNode next;
        DoubleNode pre;

        DoubleNode(int val) {
            this.val = val;
        }
    }

    private void reverseDoubleList(DoubleNode head) {
        DoubleNode next = null;
        DoubleNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
    }

}
