package Trick;

import java.util.*;

public class majorityElement {

    public static int majorityElement(int[] nums) {
        int res = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sum == 0) res = nums[i];
            sum += res == nums[i] ? 1 : -1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] splits = s.split(",");
        int[] nums = new int[splits.length];
        for(int i = 0; i < splits.length; i++) nums[i] = Integer.parseInt(splits[i]);
        System.out.print(majorityElement(nums));
    }
}
