import java.util.Stack;

/**
 * 前序、中序、后序遍历
 * 递归版本
 * 迭代版本
 */
public class Code_0601_PreInPosTraversal {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 二叉树的先序遍历 递归版
     *
     * @param head 头节点
     */
    private static void preTraversalRecursive(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        preTraversalRecursive(head.left);
        preTraversalRecursive(head.right);
    }

    /**
     * 二叉树的先序遍历 网友迭代版
     *
     * @param head 头节点
     */
    private static void preTraversalIterationWithNetizen(Node head) {

        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }

    /**
     * 二叉树先序遍历 左程云迭代版
     *
     * @param head 头节点
     */
    private static void preTraversalIterationWithZuo(Node head) {
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 二叉树的中序遍历 递归版
     *
     * @param head 头节点
     */
    private static void inTraversalRecursive(Node head) {
        if (head == null) {
            return;
        }

        inTraversalRecursive(head.left);
        System.out.println(head.val);
        inTraversalRecursive(head.right);
    }

    /**
     * 二叉树的中序遍历 迭代版
     *
     * @param head 头节点
     */
    private static void inTraversalIteration(Node head) {
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            if (!stack.isEmpty()) {
                cur = stack.pop();
                System.out.println(cur.val);
                cur = cur.right;
            }
        }

    }

    /**
     * 二叉树的后序遍历 递归版
     *
     * @param head 头节点
     */
    private static void postTraversalRecursive(Node head) {
        if (head == null) {
            return;
        }

        postTraversalRecursive(head.left);
        postTraversalRecursive(head.right);
        System.out.println(head.val);
    }

    /**
     * 二叉树的后序遍历 迭代版
     * 思路：
     * 后序遍历的顺序是 左->右->中
     * 直接写有困难，如果可以找到一个准顺序实现 中->右->左 的话 就可以利用栈进行逆序得到后序遍历了
     * 而在线序排列的方法中实现的是中->左->右 这样只要交换左右子节点的压栈顺序就可以实现 中->右->左 了
     *
     * @param head
     */
    private static void postTraversalIteration(Node head) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> helper = new Stack<>();

        stack.push(head);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            helper.push(cur);

            if (cur.left != null) {
                stack.push(cur.left);
            }

            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        while (!helper.isEmpty()) {
            System.out.println(helper.pop().val);
        }
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(-222222222);
        head.right = new Node(3);
        head.left.left = new Node(Integer.MIN_VALUE);
        head.right.left = new Node(55555555);
        head.right.right = new Node(66);
        head.left.left.right = new Node(777);

        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.left.right = new Node(7);

        head = new Node(1);
        head.left = new Node(1);
        head.right = new Node(1);
        head.left.left = new Node(1);
        head.right.left = new Node(1);
        head.right.right = new Node(1);
        head.left.left.right = new Node(1);
        postTraversalRecursive(head);
        System.out.println("========================");
        postTraversalIteration(head);
    }
}
