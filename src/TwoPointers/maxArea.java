package TwoPointers;

import java.util.Scanner;

public class maxArea {
    public static int maxArea(int[] nums) {
        int left = 0, right = nums.length - 1;
        int res = 0;
        while(left < right) {
            res = Math.max(res, (right - left) * Math.min(nums[left], nums[right]));
            if(nums[left] < nums[right]) left++;
            else right--;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] splits = line.split(" ");

        int[] nums = new int[splits.length];
        for(int i = 0; i < splits.length; i++) {
            nums[i] = Integer.parseInt(splits[i]);
        }
        System.out.println(maxArea(nums));
    }
}
