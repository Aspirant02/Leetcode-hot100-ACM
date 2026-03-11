package Greedy;

import java.util.*;

public class maxProfit {
    public static int maxProfit(int[] nums) {
        int pre = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            pre = Math.min(pre, nums[i]);
            res = Math.max(res, nums[i] - pre);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splits = str.split(",");
        int[] nums = new int[splits.length];

        for(int i = 0; i < splits.length; i++) nums[i] = Integer.parseInt(splits[i]);
        System.out.println((maxProfit(nums)));
    }
}
