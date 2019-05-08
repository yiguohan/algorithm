/**
 * 在行和列都排好序的矩阵中找数：给定一个有N*M的矩阵，行和列都是排好序的。实现一个函数，判断K是否在矩阵中
 */
public class Code_0408_FindNumInSortedMatrix {

    private static boolean isContains(int[][] matrix, int target) {
        int curR = 0;
        int curC = matrix[0].length - 1;

        while (curC >= 0 && curR < matrix.length) {
            if (matrix[curR][curC] > target) {
                curC--;
            } else if (matrix[curR][curC] < target) {
                curR++;
            } else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 3, 4, 5, 6},
                {10, 12, 13, 15, 16, 17, 18},
                {23, 24, 25, 26, 27, 28, 29},
                {44, 45, 46, 47, 48, 49, 50},
                {65, 66, 67, 68, 69, 70, 71},
                {96, 97, 98, 99, 100, 111, 122},
                {166, 176, 186, 187, 190, 195, 200},
                {233, 243, 321, 341, 356, 370, 380}
        };
        int K = 233;
        System.out.println(isContains(matrix, K));
    }


}
