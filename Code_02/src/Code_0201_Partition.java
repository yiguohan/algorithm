/**
 * Partition函数
 */
public class Code_0201_Partition {

    public static void main(String[] args) {

    }

    private static void partition(int[] arr, int target) {

        int i = -1;//小于等于区的右边界

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < target) {
                swap(arr, j, ++i);
                i++;
            }
        }

    }

    private static void swap(int[] arr, int a, int b) {
        int k = arr[a];
        arr[a] = arr[b];
        arr[b] = k;
    }
}
