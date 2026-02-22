package Matrix;

import java.io.*;
import java.util.*;

public class spiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int l = 0, r = matrix[0].length - 1;
        int u = 0, d = matrix.length - 1;

        List<Integer> res = new ArrayList<>();

        while(true) {
            for(int i = l; i <= r; i++) res.add(matrix[u][i]);
            if(++u > d) break;
            for(int i = u; i <= d; i++) res.add(matrix[i][r]);
            if(--r < l) break;
            for(int i = r; i >= l; i--) res.add(matrix[d][i]);
            if(--d < u) break;
            for(int i = d; i >= u; i--) res.add(matrix[i][l]);
            if(++l > r) break;
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(spiralOrder(matrix));
    }
}
