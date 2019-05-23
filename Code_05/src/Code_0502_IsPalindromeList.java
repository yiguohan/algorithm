/**
 * 判断一个链表是否为回文结构
 */
public class Code_0502_IsPalindromeList {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static boolean isPalindromeList(Node head) {

        if (head == null || head.next == null) {
            return true;
        }

        /**
         * 设置一个快指针fast和一个慢指针slow
         * fast一次走两步 慢指针一次走一步
         * 当fast到达链表的末尾，慢指针指向中点
         */
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        /**
         * 将中点Node的next指针指向Null 中点右边的node依次逆序
         * 两个指针从两头开始向中间走，依次比较
         */
        if (fast.next != null) {
            /**
             * Node个数为偶数的情况
             */
            fast = slow.next;//slow是左中点，fast调整到右中点
            slow.next = null;//中点next指针指向空
            Node helper = fast.next;//记录fast的next
            while (helper != null) {
                fast.next = slow;//fast逆序
                slow = fast;
                fast = helper;
                helper = helper.next;
            }
            fast.next = slow;
            slow = head;
            while (slow != null) {
                if (slow.val == fast.val) {
                    slow = slow.next;
                    fast = fast.next;
                } else {
                    return false;
                }
            }
            return true;

        } else {
            /**
             * Node个数为奇数的情况
             */
            fast = slow;
            fast = fast.next;
            slow.next = null;
            Node helper = fast.next;
            while (helper != null) {
                fast.next = slow;
                slow = fast;
                fast = helper;
                helper = helper.next;
            }
            fast.next = slow;
            slow = head;
            while (slow != null) {
                if (slow.val == fast.val) {
                    slow = slow.next;
                    fast = fast.next;
                } else {
                    return false;
                }
            }
            return true;

        }

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        isPalindromeList(head);
    }

}
