package Array;

import java.io.*;
import java.util.*;

public class firstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] >= 1 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                int j = nums[i] - 1;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        for(int i = 0; i < len; i++) {
            if(nums[i] != i + 1) return i + 1;
        }
        return len + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        int[] nums = new int[split.length];
        for(int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(firstMissingPositive(nums));
    }
}
