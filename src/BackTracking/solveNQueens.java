package BackTracking;

import java.util.*;
public class solveNQueens {
    private static List<List<String>> res;
    public static List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] c = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                c[i][j] = '.';
            }
        }
        backtracking(c, n, 0);
        return res;
    }

    public static void backtracking(char[][] c, int n, int row) {
        if(row == n) res.add(array2list(c));
        for(int col = 0; col < n; col++) {
            if(check(c, row, col, n)) {
                c[row][col] = 'Q';
                backtracking(c, n, row + 1);
                c[row][col] = '.';
            }
        }
    }

    public static List<String> array2list(char[][] c) {
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < c.length; i++) {
            String tmp = "";
            for(int j = 0; j < c.length; j++) {
                tmp += c[i][j];
            }
            ans.add(tmp);
        }
        return ans;
    }

    public static boolean check(char[][] c, int row, int col, int n) {
        for(int i = 0; i < row; i++) {
            if(c[i][col] == 'Q') return false;
        }

        for(int i = 0; i < col; i++) {
            if(c[row][i] == 'Q') return false;
        }

        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(c[i][j] == 'Q') return false;
        }

        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if(c[i][j] == 'Q') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solveNQueens(n));
    }
}
