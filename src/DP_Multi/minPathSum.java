package DP_Multi;

import java.util.*;

public class minPathSum {

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1) {
            int res = 0;
            for(int i = 0; i < n; i++) res += grid[0][i];
            return res;
        }
        if(n == 1) {
            int res = 0;
            for(int i = 0; i < m; i++) res += grid[i][0];
            return res;
        }

        int[][] dp = new int[m][n];
        int first_row = 0, first_col = 0;
        for(int i = 0; i < m; i++) {
            first_col += grid[i][0];
            dp[i][0] = first_col;
        }
        for(int i = 0; i < n; i++) {
            first_row += grid[0][i];
            dp[0][i] = first_row;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.print(minPathSum(grid));
    }
}
