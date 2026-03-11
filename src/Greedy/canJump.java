package Greedy;

import java.util.*;

public class canJump {

    public static boolean canJump(int[] nums) {
        int res = 0;
        for(int i = 0; i <= res; i++) {
            res = Math.max(res, i + nums[i]);
            if(res >= nums.length - 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splits = str.split(",");
        int[] nums = new int[splits.length];

        for(int i = 0; i < splits.length; i++) nums[i] = Integer.parseInt(splits[i]);
        System.out.println((canJump(nums)));
    }
}
