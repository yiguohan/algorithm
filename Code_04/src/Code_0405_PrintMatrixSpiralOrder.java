/**
 * 旋转打印矩阵
 */
public class Code_0405_PrintMatrixSpiralOrder {


    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix[0].length - 1;
        int dC = matrix.length - 1;
        while (tR <= dR && tC <= dC) {

            printEdge(matrix, tC++, tR++, dC--, dR--);
        }
    }

    public static void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {

        int curR = tR;
        int curC = tC;
        if (tR == dR) {
            while (curC <= dC) {
                System.out.println(matrix[curR][curC]);
                curC++;
            }

        } else if (tC == dC) {
            while (curR <= dR) {
                System.out.println(matrix[curR][curC]);
                curR++;
            }
        } else {
            while (curC < dC) {
                System.out.println(matrix[curR][curC]);
                curC++;
            }

            while (curR < dR) {
                System.out.println(matrix[curR][curC]);
                curR++;
            }
            while (curC > tC) {
                System.out.println(matrix[curR][curC]);
                curC--;
            }
            while (curR > tR) {
                System.out.println(matrix[curR][curC]);
                curR--;
            }

        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        spiralOrderPrint(matrix);

    }


}
