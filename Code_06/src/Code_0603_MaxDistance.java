/**
 * 求二叉树节点之间的最大距离
 */
public class Code_0603_MaxDistance {

    public static void main(String[] args) {

    }

    public static int maxDistance(Node x) {
        return process(x).maxDistance;
    }


    public static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int leftDistance = leftInfo.maxDistance;
        int rightDistance = rightInfo.maxDistance;
        int distance = leftInfo.height + rightInfo.height + 1;

        int maxDistance = Math.max(distance, Math.max(leftDistance, rightDistance));
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(maxDistance, height);
    }


    public static class Info {
        public int maxDistance;
        public int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
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
