/**
 * 数组实现队列
 */
public class Code_0402_ArrayToQueue {
    public static class ArrayQueue {

        private Integer[] arr;
        private Integer start = 0;
        private Integer end = 0;
        private Integer size;

        public ArrayQueue(int size) {
            if (size < 0) {
                throw new IllegalArgumentException("size must more than 0");
            }

            arr = new Integer[size];
            this.size = size;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[start];
        }

        public void push(Integer obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("the queue is full");
            }
            arr[end] = obj;
            end = getIndex(end + 1);
            size++;
        }

        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("the queue is empty");
            }
            int res = arr[start];
            start = getIndex(start + 1);
            size--;
            return res;
        }

        private int getIndex(int index) {
            if (index == size) {
                return 0;
            } else {
                return index;
            }
        }


    }
}
