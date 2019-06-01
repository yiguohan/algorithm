/**
 * 判断一棵树是否为平衡二叉树
 */
public class Code_0602_IsBalancedTree {


    private static Info isBalancedTree(Node head) {
        if (head == null) {
            return new Info(true, 0);
        }

        Info leftInfo = isBalancedTree(head.left);
        Info rightInfo = isBalancedTree(head.right);

        return new Info(leftInfo.isBalanced && rightInfo.isBalanced && Math.abs(leftInfo.height - rightInfo.height) < 2,
                Math.max(leftInfo.height, rightInfo.height));

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        System.out.println(isBalancedTree(head).isBalanced);
    }

    private static class Info {
        boolean isBalanced;
        int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}
