package BinarySearch;

import java.util.*;

public class searchRange {
    public static int[] searchRange(int[] nums, int target) {
        int left1 = 0, right1 = nums.length - 1;
        int[] res = new int[2];
        while(left1 <= right1) {
            int mid = left1 + (right1 - left1) / 2;
            if(target > nums[mid]) left1 = mid + 1;
            else right1 = mid - 1;
        }
        if(left1 == nums.length || nums[left1] != target) {
            res[0] = res[1] = -1;
        } else {
            int left2 = 0, right2 = nums.length - 1;
            target += 1;
            while(left2 <= right2) {
                int mid = left2 + (right2 - left2) / 2;
                if(target > nums[mid]) left2 = mid + 1;
                else right2 = mid - 1;
            }
            res[0] = left1;
            res[1] = left2 - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] splits = s.split(",");
        int[] nums = new int[splits.length];
        for(int i = 0; i < splits.length; i++) {
            nums[i] = Integer.parseInt(splits[i]);
        }
        int target = sc.nextInt();
        System.out.println(Arrays.toString(searchRange(nums, target)));

    }
}
