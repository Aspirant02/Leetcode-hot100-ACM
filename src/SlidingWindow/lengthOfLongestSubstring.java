package SlidingWindow;

import java.io.*;
import java.util.*;


public class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String str) {
        int res = 0, end = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++) {
            if(i > 0) set.remove(str.charAt(i - 1));
            while(end < str.length() && !set.contains(str.charAt(end))) {
                set.add(str.charAt(end));
                end++;
            }
            res = Math.max(res, end - i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(str));
    }
}
