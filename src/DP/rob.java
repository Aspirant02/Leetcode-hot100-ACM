package DP;

import java.util.*;

public class rob {
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splits = str.split(",");
        int[] nums = new int[splits.length];

        for(int i = 0; i < splits.length; i++) nums[i] = Integer.parseInt(splits[i]);
        System.out.println(rob(nums));
    }
}
