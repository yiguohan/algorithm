/**
 * 数组实现栈
 */
public class Code_0401_ArrayToStack {

    public static class ArrayStack {
        private Integer[] arr;
        private Integer size = 0;

        public ArrayStack(int size) {
            if (size < 0) {
                throw new IllegalArgumentException("stack size must more than 0");
            }

            arr = new Integer[size];
        }

        public void push(int element) {
            if (size >= arr.length) {
                throw new IllegalStateException("the stack is full");
            }
            arr[size++] = element;
        }

        public Integer pop() {
            if (size == 0) {
                throw new IllegalStateException("the stack is empty");
            }
            return arr[--size];
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[size - 1];
        }

    }

}
