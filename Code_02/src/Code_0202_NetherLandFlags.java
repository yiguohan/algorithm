/**
 * 荷兰国旗问题
 */
public class Code_0202_NetherLandFlags {

    public static void main(String[] args) {

    }

    private static void partition(int[] arr, int target) {
        int less = -1;
        int more = arr.length;
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
    }

    private static void swap(int[] arr, int a, int b) {
        int k = arr[a];
        arr[a] = arr[b];
        arr[b] = k;
    }
}
