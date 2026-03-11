package Greedy;

import java.util.*;

public class jump {

    public static int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int pre = 0, next = 0, res = 0;
        for(int i = 0; i < nums.length; i++) {
            next = Math.max(next, nums[i] + i);

            if(pre == i) {
                res++;
                pre = next;
                if(pre >= nums.length - 1) break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splits = str.split(",");
        int[] nums = new int[splits.length];

        for(int i = 0; i < splits.length; i++) nums[i] = Integer.parseInt(splits[i]);
        System.out.println(jump(nums));
    }
}
