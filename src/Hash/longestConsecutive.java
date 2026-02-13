package Hash;

import java.io.*;
import java.util.*;

public class longestConsecutive {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int e : nums) {
            set.add(e);
        }
        int res = 0;
        for(int e : set) {
            if(set.contains(e - 1)) continue;
            int y = e + 1;
            while(set.contains(y)) {
                y++;
            }
            res = Math.max(res, y - e);
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
        System.out.println(longestConsecutive(nums));
    }
}
