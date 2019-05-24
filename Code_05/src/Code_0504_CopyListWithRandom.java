import java.util.HashMap;

/**
 * 题目：一种特殊的链表节点类如下Node类中的value是节点值，
 * next指针和正常链表的next指针一样指向下一个节点，
 * rand指针是Node类中新增的指针，指向任意节点，也可能指向null。
 * 给定一个由Node节点组成的无环单链表的头结点head。
 * 请实现一个函数完成该链表中所有结构的复制，并返回新链表的头结点。
 * <p>
 * 进阶：额外空间复杂度为O(1)，时间复杂度O(N)
 */
public class Code_0504_CopyListWithRandom {

    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 基础版 不对时间空间做限制要求 利用HashMap
     *
     * @param head
     * @return
     */
    private static Node copyListWithRand1(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);

    }

    /**
     * 进阶版 额外空间复杂度为O(1)，时间复杂度O(N)
     *
     * @param head
     * @return
     */
    private static Node copyListWithRand2(Node head) {
        if (head == null) {
            return null;
        }
        Node next = null;
        Node current = head;
        while (current != null) {
            next = current.next;
            current.next = new Node(current.value);
            current.next.next = next;
            current = next;
        }

        current = head;
        Node nodeCopy = null;
        while (current != null) {
            nodeCopy = current.next;
            nodeCopy.rand = current.rand == null ? null : current.rand.next;
            current = current.next.next;
        }

        nodeCopy = head.next;
        Node headCopy = nodeCopy;
        while (nodeCopy != null) {
            nodeCopy.next = nodeCopy.next == null ? null : nodeCopy.next.next;
            nodeCopy = nodeCopy.next;
        }
        return headCopy;
    }


    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }
}
