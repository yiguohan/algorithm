/**
 * 二分查找
 */
public class Code_0101_BinarySort {

    public static void main(String args[]) {
        int[] testArr = new int[]{1, 3, 5, 6, 7, 32, 33, 55, 77, 123, 222, 333};
        int target = 333;
        int res = binarySortByWhile(testArr, target);
        System.out.println(res);
    }

    /**
     * 递归方式的二分查找
     *
     * @param arr
     * @param target
     */
    private static int binarySortByRecursive(int[] arr, int start, int end, int target) {
        if (arr == null || arr.length < 1 || start >= end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] > target) {
            return binarySortByRecursive(arr, start, mid - 1, target);
        } else if (arr[mid] < target) {
            return binarySortByRecursive(arr, mid + 1, end, target);
        } else {
            return mid;
        }
    }

    /**
     * 非递归方式的二分查找
     *
     * @param arr
     * @param target
     */
    private static int binarySortByWhile(int[] arr, int target) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
