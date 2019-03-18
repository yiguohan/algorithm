/**
 * Partition函数
 * <p>
 * 问题描述：给一个数组，再给定一个划分值，把小于等于划分值的数放在数组的左边，大于划分值的数放在数组右边。小于和大于区域不需要排序。要求时间复杂度是O(N)，额外空间复杂度是O(1)。
 */
public class Code_0201_Partition {

    public static void main(String[] args) {
        int[] test = {2, 3, 4, 7, 5, 5, 9, 2, 1, 2, 3, 4, 8, 5, 2};
        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 5);
        printArray(res);
    }

    private static int[] partition(int[] arr, int l, int r, int target) {

        int i = l - 1;//小于等于区的右边界
        int j = l;
        while (j <= r) {
            if (arr[j] < target) {
                swap(arr, j, i + 1);
                i++;
            }
            j++;
        }
        return arr;

    }

    private static void swap(int[] arr, int a, int b) {
        int k = arr[a];
        arr[a] = arr[b];
        arr[b] = k;
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
