import java.util.Stack;

/**
 * * 仅用队列结构实现栈结构
 * <p>
 * * 仅用栈结构实现队列结构
 */
public class Code_0404_StackAndQueueConvert {

    /**
     * 仅用栈结构实现队列结构
     * 思路：
     * 1.声明两个栈 pushStack 和 popStack
     * <p>
     * 2。存数据往pushStack 取数据在popStack
     * <p>
     * 3. popStack为空时，从pushStack中依次去除数，一次性取完
     */
    public static class TwoStacksQueue {
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public TwoStacksQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        public void enqueue(int pushInt) {
            pushStack.push(pushInt);
        }

        public int dequeue() {
            if (popStack.empty() && pushStack.empty()) {
                throw new IndexOutOfBoundsException("empty");
            } else if (popStack.empty()) {
                poll();
            }

            return popStack.pop();

        }

        public int peek() {
            if (popStack.empty() && pushStack.empty()) {
                throw new IndexOutOfBoundsException("empty");
            } else if (popStack.empty()) {
                poll();
            }
            return popStack.peek();
        }

        private void poll() {
            //从pushStack中一次性取完数放入popStack
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    public static class TwoQueuesStack {

    }
}
