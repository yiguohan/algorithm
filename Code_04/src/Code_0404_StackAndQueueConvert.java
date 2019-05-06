import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 仅用栈结构实现队列结构
 * <p>
 * *仅用队列结构实现栈结构
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

    /**
     * 仅用队列结构实现栈结构
     * <p>
     * 思路：
     * 1. 队列的具体实现可使用LinkedList，入队、出队和peek分别对应方法add/poll/peek
     * <p>
     * 2. 准备两个队列对象，一个叫queue，一个叫help
     * <p>
     * 3. 入队加入queue操作
     * <p>
     * 4. 出队时循环queue把所有数依序放入help，留下最后一个返回，queue和help交换引用
     * <p>
     * 5. peek操作类似出队，不同点在于返回最后一个同时还要加进help队列中
     */
    public static class TwoQueuesStack {
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueuesStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(int pushInt) {
            queue.add(pushInt);
        }

        public int pop() {
            if (queue.size() == 0) {
                throw new IndexOutOfBoundsException("empty");
            }

            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;

        }

        public int peek() {
            if (queue.size() == 0) {
                throw new IndexOutOfBoundsException("empty");
            }

            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            swap();
            help.add(res);
            return res;
        }

        private void swap() {
            Queue<Integer> temp = queue;
            queue = help;
            help = temp;
        }
    }
}
