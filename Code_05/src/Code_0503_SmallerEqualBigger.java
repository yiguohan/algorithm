/**
 * * 将单向链表划分成左边小、中间相等、右边大的形式
 * *    进阶要求
 * *        时间复杂度O(N)
 * *        要求额外空间复杂度为O(1)
 * *        要求类似保持稳定性，小于、等于、大于的相对次序不变
 */
public class Code_0503_SmallerEqualBigger {

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
//        head1 = listPartition1(head1, 4);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }


    /**
     * 初阶方式 不要求稳定性 和 额外空间复杂度
     *
     * @param head
     * @return
     */
    private static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }

        int i = 0;
        Node cur = head;
        while (cur != null) {
            i++;
            cur = cur.next;
        }

        Node[] nodeArr = new Node[i];

        for (int j = 0; j != nodeArr.length; j++) {
            nodeArr[j] = head;
            head = head.next;
        }

        int smallIndex = -1;
        int bigIndex = nodeArr.length;
        int index = 0;

        while (index != bigIndex) {
            if (nodeArr[index].val < pivot) {
                swap(nodeArr, index++, ++smallIndex);
            } else if (nodeArr[index].val == pivot) {
                index++;
            } else {
                swap(nodeArr, index, --bigIndex);
            }
        }

        for (int j = 0; j < nodeArr.length; j++) {
            if (j < nodeArr.length - 1) {
                nodeArr[j].next = nodeArr[j + 1];
            } else {
                nodeArr[j].next = null;
            }
        }

        return nodeArr[0];

    }

    private static void swap(Node[] arr, int index1, int index2) {
        Node temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * 高阶：要求额外空间复杂度 O(1) 保证稳定性
     *
     * @param head
     * @param pivot
     * @return
     */
    private static Node listPartition2(Node head, int pivot) {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.val == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : (eH != null ? eH : bH);
    }


    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }


}
