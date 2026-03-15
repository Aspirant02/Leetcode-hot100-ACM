package Trick;

import java.util.*;

public class singleNumber {

    public static int singleNumber(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) res ^= nums[i];
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] splits = s.split(",");
        int[] nums = new int[splits.length];
        for(int i = 0; i < splits.length; i++) nums[i] = Integer.parseInt(splits[i]);
        System.out.print(singleNumber(nums));
    }
}
