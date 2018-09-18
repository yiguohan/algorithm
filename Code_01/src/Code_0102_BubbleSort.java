/**
 * 冒泡排序
 */
public class Code_0102_BubbleSort {

    public static void main(String args[]) {
        int[] testArr = new int[]{2, 3, 1, 4, 5, 3, 2, 1, 5, 2, 45, 5, 66};
        bubbleSort(testArr);
        for (int i :
                testArr) {
            System.out.println(i);
        }
    }

    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 交换位置的方法
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }
}
