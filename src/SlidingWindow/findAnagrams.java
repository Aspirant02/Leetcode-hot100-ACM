package SlidingWindow;

import java.io.*;
import java.util.*;

public class findAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        int[] swindow = new int[26];
        int[] pwindow = new int[26];
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) return res;

        for(int i = 0; i < p.length(); i++) {
            swindow[s.charAt(i) - 'a']++;
            pwindow[p.charAt(i) - 'a']++;
        }

        if(Arrays.equals(pwindow, swindow)) res.add(0);

        for(int i = 1; i <= s.length() - p.length(); i++) {
            swindow[s.charAt(i - 1) - 'a']--;
            swindow[s.charAt(i + p.length() - 1) - 'a']++;
            if(Arrays.equals(pwindow, swindow)) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        System.out.println(findAnagrams(s, p));
    }
}
