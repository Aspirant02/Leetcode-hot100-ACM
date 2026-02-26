package Matrix;

import java.util.*;
import java.io.*;

public class searchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = 0;
        while(m >= 0 && n < matrix[0].length){
            if(matrix[m][n] == target) return true;
            else if(matrix[m][n] > target) {
                m--;
            }

            else n++;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        int target = sc.nextInt();
        System.out.println(searchMatrix(nums, target));
    }
}
