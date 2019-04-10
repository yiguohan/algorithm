import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 * * 要求：
 * * pop/push/getMin操作的时间复杂度都是O(1)
 * * 设计的栈类型可以使用现成的栈结构
 */
public class Code_0403_GetMinStack {
    public static class GetMinStack {
        private Stack<Integer> normalStack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public void push(Integer obj) {
            normalStack.push(obj);
            if (minStack.isEmpty()) {
                minStack.push(obj);
            } else if (this.getMin() <= obj) {
                minStack.push(this.getMin());
            } else {
                minStack.push(obj);
            }
        }

        public Integer pop() {
            minStack.pop();
            return normalStack.pop();
        }

        public Integer peek() {
            return normalStack.peek();
        }

        public Integer getMin() {
            return minStack.peek();
        }

    }

    public static void main(String[] args){
        GetMinStack stack = new GetMinStack();
        stack.push(3);
        System.out.println(stack.getMin());
        stack.push(4);
        System.out.println(stack.getMin());
        stack.push(1);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }
}
