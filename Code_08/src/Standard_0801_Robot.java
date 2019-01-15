public class Standard_0801_Robot {

    public static int getWay1(int n, int p, int m, int k) {
        return process(p, k, n, m);
    }

    /**
     * 暴力递归版
     *
     * @param cur  当前的位置->可变参数
     * @param rest 剩多少步->可变参数
     * @param n    一共有n个位置->固定参数
     * @param aim  最终的目标->固定参数
     * @return 从cur出发，还剩rest步的情况下，最终来到aim位置，走的过程不能越界，有多少种方法
     */
    public static int process(int cur, int rest, int n, int aim) {
        if (cur == 0 || cur > n) {
            return 0;
        }
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            return process(2, rest - 1, n, aim);
        }
        if (cur == n) {
            return process(n - 1, rest - 1, n, aim);
        }
        return process(cur - 1, rest - 1, n, aim) + process(cur + 1, rest - 1, n, aim);
    }

    /**
     * 动态规划版
     *
     * @param n 总个数
     * @param p 初始位置
     * @param m 目标位置
     * @param k 走过的步数
     * @return
     */
    public static int getWay2(int n, int p, int m, int k) {
        int[][] dp = new int[k + 1][n + 1];
        dp[0][m] = 1;
        for (int row = 1; row <= k; row++) {
            for (int col = 1; col <= n; col++) {
                if (col == 1) {
                    dp[row][col] = dp[row - 1][2];
                } else if (col == n) {
                    dp[row][col] = dp[row - 1][n - 1];
                } else {
                    dp[row][col] = dp[row - 1][col - 1] + dp[row - 1][col + 1];
                }
            }
        }
        return dp[k][p];
    }
}
