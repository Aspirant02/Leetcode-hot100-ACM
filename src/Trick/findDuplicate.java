package Trick;

import java.util.*;

public class findDuplicate {

    public static int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int p = 0, q = slow;
        while(p != q) {
            p = nums[p];
            q = nums[q];
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] splits = s.split(",");
        int[] nums = new int[splits.length];
        for(int i = 0; i < splits.length; i++) nums[i] = Integer.parseInt(splits[i]);
        System.out.print(findDuplicate(nums));
    }
}
