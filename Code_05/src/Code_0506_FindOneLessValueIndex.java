/**
 * 题目：给定一个数组，任意相邻的两个数不相等且无序。
 * 定义局部最小的概念：前后的相邻元素都比自己大，边界上看相邻的数比自己大，则说明该数为局部最小。
 * 请返回任意一个局部最小的数。
 */
public class Code_0506_FindOneLessValueIndex {
    /**
     * 1.洗参数
     * 2.排除边界上的情况
     * 3.二分法得出答案
     */

    private int process(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1 || arr[0] < arr[1]) {
            return arr[0];
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }

        int left = 1;
        int right = arr.length - 2;
        int mid = (left + right) / 2;


        while (left < right) {
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
                mid = (left + right) / 2;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}
