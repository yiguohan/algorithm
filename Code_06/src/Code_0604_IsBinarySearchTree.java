/**
 * 判断一棵二叉树是否为搜索二叉树
 * 搜索二叉树的性质：左子树的值均小于当前节点，右子树的值均大于当前节点，两棵子树均为搜索二叉树
 */
public class Code_0604_IsBinarySearchTree {


    public static void main(String[] args) {

    }


    private static Info getInfo(Node head) {
        if (head == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = getInfo(head.left);
        Info rightInfo = getInfo(head.right);

        boolean isBinarySearchTree = leftInfo.isBinarySearchTree
                && rightInfo.isBinarySearchTree
                && (head.val > leftInfo.maxValue && head.val < rightInfo.minValue);

        int minValue = Math.min(head.val, Math.min(leftInfo.minValue, rightInfo.minValue));
        int maxValue = Math.max(head.val, Math.max(leftInfo.maxValue, rightInfo.maxValue));

        return new Info(isBinarySearchTree, minValue, maxValue);

    }

    private static class Info {
        boolean isBinarySearchTree;
        int minValue;
        int maxValue;

        public Info(boolean isBinarySearchTree, int minValue, int maxValue) {
            this.isBinarySearchTree = isBinarySearchTree;
            this.minValue = minValue;
            this.maxValue = maxValue;
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
