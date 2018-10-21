/**
 * 判断一棵二叉树是否为搜索二叉树
 */
public class Code_0604_IsBinarySearchTree {


    public static boolean isBinarySearchTree(Node x) {
        return process(x).isBinarySearchTree;
    }


    public static Info process(Node x) {
        if (x == null) {
            return new Info(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Info left = process(x.left);
        Info right = process(x.right);

        boolean isBinarySearch = left.isBinarySearchTree
                && right.isBinarySearchTree
                && x.value > left.max
                && x.value < right.min;
        int min = Math.min(x.value, Math.min(left.min, right.min));
        int max = Math.max(x.value, Math.max(left.max, right.max));

        return new Info(isBinarySearch, min, max);
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Info {
        public boolean isBinarySearchTree;
        public int min;
        public int max;

        public Info(boolean isBinarySearchTree, int min, int max) {
            this.isBinarySearchTree = isBinarySearchTree;
            this.min = min;
            this.max = max;
        }
    }
}
