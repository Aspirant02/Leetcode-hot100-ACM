package Stack;

import java.util.*;

public class largestRectangleArea {

    public static int largestRectangleArea(int[] nums) {
        int len = nums.length;;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = -1;
        right[len - 1] = len;
        for(int i = 1; i < len; i++) {
            int j = i - 1;
            while(j >= 0 && nums[j] >= nums[i]) {
                j = left[j];
            }
            left[i] = j;
        }

        for(int i = len - 2; i >= 0; i--) {
            int j = i + 1;
            while(j <= len - 1 && nums[j] >= nums[i]) {
                j = right[j];
            }
            right[i] = j;
        }

        int res = 0;
        for(int i = 0; i < len; i++) {
            int tmp = (right[i] - left[i] - 1) * nums[i];
            res = Math.max(res, tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] splits = s.split(",");
        int[] nums = new int[splits.length];
        for(int i = 0; i < splits.length; i++) nums[i] = Integer.parseInt(splits[i]);

        System.out.println(largestRectangleArea(nums));
    }
}
