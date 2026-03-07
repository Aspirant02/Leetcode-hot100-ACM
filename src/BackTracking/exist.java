package BackTracking;

import java.util.*;

public class exist {

    public static boolean exist(char[][] board, String word) {
        char[] c = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, i, j, c, 0)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, int i, int j, char[] c, int k) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != c[k]) return false;
        if(k == c.length - 1) return true;

        board[i][j] = '0';
        boolean res = dfs(board, i + 1, j, c, k + 1) || dfs(board, i - 1, j, c, k + 1) || dfs(board, i, j + 1, c, k + 1) || dfs(board, i, j - 1, c, k + 1);
        board[i][j] = c[k];
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        char[][] board = new char[m][n];
        for(int i = 0; i < m; i++) {
            String s = sc.nextLine();
            board[i] = s.toCharArray();
        }
        String word = sc.nextLine();
        System.out.print(exist(board, word));
    }
}
