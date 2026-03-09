package BinarySearch;

import java.util.*;

public class findMin {

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]) right = mid;
            else left = mid + 1;
        }
        return nums[right];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splits = str.split(",");
        int[] nums = new int[splits.length];

        for(int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(splits[i]);
        }

        System.out.print(findMin(nums));
    }
}
