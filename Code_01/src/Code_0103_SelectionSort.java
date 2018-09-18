/**
 * 选择排序
 */
public class Code_0103_SelectionSort {

    public static void main(String args[]) {
        int[] testArr = new int[]{2, 3, 1, 4, 5, 3, 2, 1, 5, 2, 45, 5, 66};
        selectionSort(testArr);
        for (int i :
                testArr) {
            System.out.println(i);
        }
    }

    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 1; i--) {
            int maxIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(arr, maxIndex, i);
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
