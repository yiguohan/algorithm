import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树或多叉树的宽度优先遍历
 * 基础：宽度优先遍历
 * 进阶：宽度有限遍历+之字形打印
 */
public class Code_0608_NAryTree {


    public static void levelOrder(DTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<DTreeNode> current = new Stack<>();
        Stack<DTreeNode> helper = new Stack<>();
        boolean isFromFront = true;
        current.push(root);
        while (!current.isEmpty()) {
            print(current, helper, isFromFront);
            isFromFront = !isFromFront;
            Stack<DTreeNode> temp = current;
            current = helper;
            helper = temp;
            helper.clear();
        }
    }

    private static void print(Stack<DTreeNode> current, Stack<DTreeNode> helper, boolean isFromFront) {
        while (!current.isEmpty()) {
            DTreeNode node = current.pop();
            System.out.println("node--------" + node.val);
            if (node.children != null) {
                if (isFromFront) {
                    for (DTreeNode dTreeNode : node.children) {
                        helper.push(dTreeNode);
                    }
                } else {
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        helper.push(node.children.get(i));
                    }
                }
            }
        }
    }


    public static class DTreeNode {

        public int getVal() {
            return this.val;
        }

        public void setVal(final int val) {
            this.val = val;
        }

        private int val;

        public List<DTreeNode> getChildren() {
            return this.children;
        }

        public void setChildren(final List<DTreeNode> children) {
            this.children = children;
        }

        private List<DTreeNode> children;


        public DTreeNode() {

        }

        public DTreeNode(int val, List<DTreeNode> children) {
            val = val;
            children = children;
        }

        public DTreeNode(int val) {
            this.val = val;
            this.children = null;
        }
    }

    public static void main(String[] args) {
        DTreeNode first_1 = new DTreeNode(5);
        DTreeNode first_2 = new DTreeNode(6);
        DTreeNode first_3 = new DTreeNode(7);


        DTreeNode s_1 = new DTreeNode(8);
        DTreeNode s_2 = new DTreeNode(9);
        DTreeNode s_3 = new DTreeNode(10);

        DTreeNode t_1 = new DTreeNode(11);
        DTreeNode t_2 = new DTreeNode(12);
        DTreeNode t_3 = new DTreeNode(13);


        List<DTreeNode> list1 = new ArrayList<>();
        list1.add(first_1);
        list1.add(first_2);
        list1.add(first_3);


        List<DTreeNode> list2 = new ArrayList<>();
        list2.add(s_1);
        list2.add(s_2);
        list2.add(s_3);

        List<DTreeNode> list3 = new ArrayList<>();
        list3.add(t_1);
        list3.add(t_2);
        list3.add(t_3);


        DTreeNode first = new DTreeNode(2);
        DTreeNode two = new DTreeNode(3);
        DTreeNode three = new DTreeNode(4);
        first.setChildren(list1);
        two.setChildren(list2);
        three.setChildren(list3);

        DTreeNode root = new DTreeNode(1);
        List<DTreeNode> list = new ArrayList<>();
        list.add(first);
        list.add(two);
        list.add(three);
        root.setChildren(list);
        levelOrder(root);
    }
}
