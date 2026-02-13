package TwoPointers;

import java.io.*;
import java.util.*;

public class moveZeroes {
    public static int[] moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        for(; right < nums.length; right++) {
            if(nums[right] != 0) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                left++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();;
        String[] splits = line.split(" ");
        int[] nums = new int[splits.length];
        for(int i = 0; i < splits.length; i++) {
            nums[i] = Integer.parseInt(splits[i]);
        }
        System.out.println(Arrays.toString(moveZeroes(nums)));
    }
}
