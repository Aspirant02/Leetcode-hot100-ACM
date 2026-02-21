package Array;

import java.util.*;
import java.io.*;

public class merge {

    public static int[][] merge(int[][] nums) {
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        int start = nums[0][0];
        int end = nums[0][1];
        for (int i = 1; i < nums.length; i++) {
            if (end < nums[i][0]) {
                res.add(new int[]{start, end});
                start = nums[i][0];
                end = nums[i][1];
            } else {
                end = Math.max(end, nums[i][1]);
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        System.out.println(Arrays.deepToString(merge(nums)));
    }
}
