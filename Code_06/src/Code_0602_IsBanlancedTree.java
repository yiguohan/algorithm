/**
 * 判断一棵树是否为平衡二叉树
 */
public class Code_0602_IsBanlancedTree {

    public static void main(String[] args) {

    }


    public static boolean isBalanced(Node x) {
        return process(x).isBalanced;
    }


    public static Info process(Node x) {
        if (x == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        boolean isBalanced = leftInfo.isBalanced
                && rightInfo.isBalanced
                && Math.abs(leftInfo.height - rightInfo.height) < 2;
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(isBalanced, height);
    }

    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
}
