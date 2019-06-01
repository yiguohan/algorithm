/**
 * 求二叉树节点之间的最大距离
 */
public class Code_0603_MaxDistance {


    public static void main(String[] args) {

    }


    private static Info maxDistance(Node head) {
        if (head == null) {
            return new Info(0, 0);
        }

        Info left = maxDistance(head.left);
        Info right = maxDistance(head.right);

        int length = Math.max(left.length, right.length) + 1;
        int maxDistance = Math.max(left.length + right.length + 1, Math.max(left.length, right.length));

        return new Info(maxDistance, length);
    }

    private static class Info {
        int maxDistance;
        int length;

        public Info(int maxDistance, int length) {
            this.maxDistance = maxDistance;
            this.length = length;
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
