package Array;

import java.io.*;
import java.util.*;

public class rotate {
    public static int[] rotate(int[] nums, int k) {
        nums = reverse(nums, 0, nums.length - 1);
        nums = reverse(nums, 0, k - 1);
        nums = reverse(nums, k, nums.length - 1);
        return nums;
    }
    public static int[] reverse(int[] nums, int left, int right) {
        while(left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
        return nums;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        String[] split = str.split(",");
        int[] nums = new int[split.length];
        for(int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(Arrays.toString(rotate(nums, k)));
    }
}
