/**
 * 荷兰国旗问题
 * 问题描述：给定一个数组，给定一个划分值，请划分出小于 等于和大于区域
 */
public class Code_0202_NetherLandFlags {

    public static void main(String[] args) {
        int[] test = generateArray();

        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    private static int[] partition(int[] arr, int l, int r, int target) {
        int less = l - 1;
        int more = r + 1;
        int i = 0;
        while (i < more) {
            if (arr[i] > target) {
                swap(arr, i, more - 1);
                more--;
            } else if (arr[i] < target) {
                swap(arr, i, less + 1);
                i++;
                less++;
            } else {
                i++;
            }
        }
        return new int[]{less + 1, more - 1};
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
            arr[i] = (int) (Math.random() * 3);
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
