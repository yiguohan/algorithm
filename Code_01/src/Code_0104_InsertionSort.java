/**
 * 插入排序
 */
public class Code_0104_InsertionSort {

    public static void main(String args[]) {
        int[] testArr = new int[]{2, 3, 1, 4, 5, 3, 2, 1, 5, 2, 45, 5, 66};
        insertionSort(testArr);
        for (int i :
                testArr) {
            System.out.println(i);
        }
    }

    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }

        for (int i = 1; i <= arr.length - 1; i++) {
            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
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
