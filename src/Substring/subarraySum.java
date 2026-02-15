package Substring;

import java.io.*;
import java.util.*;

public class subarraySum {
    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if(map.containsKey(pre - k)) res += map.get(pre - k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splits = str.split(",");
        int[] nums = new int[splits.length];
        for(int i = 0; i < splits.length; i++) nums[i] = Integer.parseInt(splits[i]);

        int k = sc.nextInt();
        System.out.println(subarraySum(nums, k));
    }
}
