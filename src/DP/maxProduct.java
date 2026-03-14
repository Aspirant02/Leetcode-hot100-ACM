package DP;

import java.util.*;

public class maxProduct {

    public static int maxProduct(int[] nums) {
        int len = nums.length;
        int[] fmax = new int[len];
        int[] fmin = new int[len];
        fmax[0] = nums[0];
        fmin[0] = nums[0];
        for(int i = 1; i < len; i++) {
            fmax[i] = Math.max(Math.max(fmax[i - 1] * nums[i], fmin[i - 1] * nums[i]), nums[i]);
            fmin[i] = Math.min(Math.min(fmax[i - 1] * nums[i], fmin[i - 1] * nums[i]), nums[i]);
        }
        int res = nums[0];
        for(int i = 1; i < len; i++) {
            res = Math.max(res, fmax[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] splits = s.split(",");
        int[] nums = new int[splits.length];
        for(int i = 0; i < splits.length; i++) nums[i] = Integer.parseInt(splits[i]);
        System.out.print(maxProduct(nums));
    }
}
