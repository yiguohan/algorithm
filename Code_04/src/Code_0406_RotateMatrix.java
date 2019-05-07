/**
 * 旋转矩阵
 * 思路：
 * 1. 先想好框架：同旋转打印一样，按圈旋转，先确定好圈，再写旋转代码
 * <p>
 * 2. 因为是正方形，所以不用考虑边长不等的情况
 */
public class Code_0406_RotateMatrix {

    private static void process(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;

        while (tR < dR) {
            rotate(matrix, tR++, tC++, dR--, dC--);
        }

    }

    private static void rotate(int[][] matrix, int tR, int tC, int dR, int dC) {
        int temp = 0;
        for (int i = 0; i < dR - tR; i++) {
            temp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = temp;
        }


    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        printMatrix(matrix);
        process(matrix);
        System.out.println("=========");
        printMatrix(matrix);
    }

}
