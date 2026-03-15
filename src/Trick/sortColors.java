package Trick;

import java.util.*;

public class sortColors {

    public static void sortColors(int[] nums) {
        int p0 = 0, p1 = 0;
        for(int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            nums[i] = 2;
            if(tmp <= 1) nums[p1++] = 1;
            if(tmp == 0) nums[p0++] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] splits = s.split(",");
        int[] nums = new int[splits.length];
        for(int i = 0; i < splits.length; i++) nums[i] = Integer.parseInt(splits[i]);
        sortColors(nums);
        System.out.print(Arrays.toString(nums));
    }
}
