/**
 * 小和问题
 */
public class Code_0106_SmallSum {

    public static void main(String[] args) {

    }

    private static int process(int[] arr) {
        if (arr == null && arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }
        int middle = start + (end - start) / 2;
        return mergeSort(arr, start, middle) + mergeSort(arr, middle + 1, end) + merge(arr, start, middle, end);
    }

    private static int merge(int[] arr, int left, int middle, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = middle + 1;
        int res = 0;

        while (p1 <= middle && p2 <= right) {
            res += arr[p1] < arr[p2] ? arr[p1] * (right - middle + 1) : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= middle) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
        return res;

    }
}
