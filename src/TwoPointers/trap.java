package TwoPointers;

import java.io.*;
import java.util.*;

public class trap {
    public static int trap(int[] height) {
        int len = height.length;;
        if(len <= 2) return 0;
        int res = 0;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        leftMax[0] = height[0];
        for(int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[len - 1] = height[len - 1];
        for(int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for(int i = 1; i < len - 1; i++) {
            int sum = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(sum > 0) res += sum;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] splits = line.split(",");
        int[] height = new int[splits.length];
        for(int i = 0; i < height.length; i++) height[i] = Integer.parseInt(splits[i]);
        System.out.println(trap(height));
    }
}
