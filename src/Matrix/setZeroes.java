package Matrix;

import java.io.*;
import java.util.*;

public class setZeroes {
    public static int[][] setZeroes(int[][] matrix) {
        boolean first_col = false;
        boolean first_row = false;
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                first_col = true;
                break;
            }
        }
        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                first_row = true;
                break;
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(first_row) {
            for(int i = 0; i < matrix[0].length; i++) matrix[0][i] = 0;
        }
        if(first_col) {
            for(int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
        }
        return matrix;

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

        System.out.println(Arrays.deepToString(setZeroes(matrix)));
    }
}

