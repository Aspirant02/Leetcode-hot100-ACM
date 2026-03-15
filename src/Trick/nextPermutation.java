package Trick;

import java.util.*;

public class nextPermutation {

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        for(; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) break;
        }

        if(i >= 0) {
            int j = len - 1;
            for (; j > i; j--) {
                if (nums[j] > nums[i]) break;
            }

            swap(nums, i, j);
        }

        reverse(nums, i + 1, len - 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void reverse(int[] nums, int left, int right) {
        while(left < right) {
            swap(nums, left++, right--);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] splits = s.split(",");
        int[] nums = new int[splits.length];
        for(int i = 0; i < splits.length; i++) nums[i] = Integer.parseInt(splits[i]);
        nextPermutation(nums);
        System.out.print(Arrays.toString(nums));
    }
}
