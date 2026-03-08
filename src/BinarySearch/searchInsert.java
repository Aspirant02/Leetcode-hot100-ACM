package BinarySearch;

import java.util.*;

public class searchInsert {

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target > nums[mid]) left = mid + 1;
            else if(target < nums[mid]) right = mid - 1;
            else return mid;
        }
        return left;
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
        System.out.println(searchInsert(nums, target));

    }
}
