/**
 * "之"字型打印矩阵
 */
public class Code_0407_ZigZagPrintMatrix {


    private static void process(int[][] matrix) {
        int p1R = 0;
        int p1C = 0;
        int p2R = 0;
        int p2C = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean isFromTop = false;
        while (p1R != endR + 1) {
            printLine(matrix, p1R, p1C, p2R, p2C, isFromTop);
            p1R = p1C == endC ? p1R + 1 : p1R;
            p1C = p1C == endC ? p1C : p1C + 1;
            p2C = p2R == endR ? p2C + 1 : p2C;
            p2R = p2R == endR ? p2R : p2R + 1;
            isFromTop = !isFromTop;
        }
        System.out.println();
    }

    private static void printLine(int[][] m, int p1R, int p1C, int p2R, int p2C, boolean isFromTop) {
        if (isFromTop) {
            while (p1R != p2R + 1) {
                System.out.print(m[p1R++][p1C--] + " ");
            }
        } else {
            while (p2R != p1R - 1) {
                System.out.print(m[p2R--][p2C++] + " ");
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        process(matrix);
    }
}
