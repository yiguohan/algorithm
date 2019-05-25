/**
 * 问题：在本题中，单链表可能有环也可能无环。
 * 给定两个单链表的头结点head1和head2，这两链表可能相交，也可能不相交。
 * 请实现一个函数，如果两链表相交，请返回相交的第一个节点，如果两链表不相交，请返回空
 */
public class Code_0505_FindFirstIntersectNode {
    /**
     * 思路分析：对于给出的两链表，有以下几种情况可以讨论
     * 1.两链表一个有环一个无环，结论：无相交节点，返回空
     * 2.两链表均有环
     * 2.1 两链表无相交节点
     * 2.2 两链表有相交节点
     * 2.2.1 链表的相交节点在入环节点之前
     * 2.2.2 链表的相交节点在入环节点之后
     * 3.两链表均无环
     * 3.1 两链表不相交，返回空
     * 3.2 两链表相交
     */


    private static Node process(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        /**
         * 两个列表均有入环节点
         */
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }

        /**
         * 两链表均无入环节点
         */
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }

        /**
         * 其他情况下不可能存在两链表相交的情况
         */
        return null;
    }

    /**
     * 获取入环节点，如果有环返回入环节点，没有环返回空
     *
     * @param head
     * @return
     */
    private static Node getLoopNode(Node head) {
        /**
         * 获取入环节点的小trick：
         * 1.设置一个快指针和一个慢指针，快指针一次走两步，慢指针依次走一步
         * 2.当快指针走到空时，两指针若没有相遇，则无入环节点
         * 3.当快指针和慢指针相遇时，慢指针不变，快指针移回起点，慢指针不动
         * 4.快指针行进速度变为一次走一步，快指针与慢指针再次开始走
         * 5.当快指针和慢指针相遇时，即到达入环节点
         */
        Node fast = head.next == null ? null : head.next.next;
        Node slow = head.next;
        if (fast == null) {
            return null;
        }

        while (fast != slow) {
            if (fast == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }

        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;

    }

    /**
     * 当两个链表均有环时，获取相交节点，没有相交节点返回空
     *
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        /**
         * 1.判断两个入环节点loop1,loop2是否相等
         * 1.1 若相等，则按照无环链表head1->loop1,head2->loop2方式（Y或V型）查找相交节点
         * 1.2 若不相等，则利用任意一个入环节点开始往下查找
         * 1.2.1 在找回到自己之前若找到另一个入环节点，则返回两个入环节点的任意一个均为相交节点
         * 1.2.2 循环回到了自己的节点并没有找到另一个链表的入环节点，则说明两链表不相交，返回空
         */

        if (loop1 == loop2) {
            Node cur1 = head1;
            Node cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }

            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }

            cur1 = head1;
            cur2 = head2;

            if (n > 0) {
                while (n != 0) {
                    cur1 = cur1.next;
                    n--;
                }
            } else {
                while (n != 0) {
                    cur2 = cur2.next;
                    n++;
                }
            }

            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }

            return cur1;

        } else {
            Node cur = loop1.next;
            while (cur != loop1) {
                if (cur == loop2) {
                    return cur;
                }
                cur = cur.next;
            }
            return null;
        }
    }

    /**
     * 当两个链表均无环时，获取相交节点，没有相交节点返回空
     *
     * @param head1
     * @param head2
     * @return
     */
    private static Node noLoop(Node head1, Node head2) {
        /**
         * 1.对两链表循环直到其各自的尾节点，并在此过程中记录两链表长度的差值N
         * 2.若两链表尾节点不同，则说明不相交，返回空
         * 3.若两链表尾节点相同，则从头开始，让长的链表先走N步，然后两链表一起走，相等时返回相交节点
         */

        int n = 0;
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }

        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }

        if (cur1 != cur2) {
            return null;
        }

        cur1 = head1;
        cur2 = head2;
        if (n > 0) {
            while (n != 0) {
                cur1 = cur1.next;
                n--;
            }
        } else {
            while (n != 0) {
                cur2 = cur2.next;
                n++;
            }
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;

    }


    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(process(head1, head2).val);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        //0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(process(head1, head2).val);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(process(head1, head2).val);

    }
}
