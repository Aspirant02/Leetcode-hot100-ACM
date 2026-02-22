package Substring;

import java.io.*;
import java.util.*;

public class minWindow {
    public static String minWindow(String s, String t) {
        int[] swindow = new int[128];
        int[] twindow = new int[128];

        for(char c : t.toCharArray()) {
            twindow[c]++;
        }
        char[] ch_t = s.toCharArray();
        int res_L = -1, res_R = ch_t.length;
        int l = 0, r = 0;
        for(; r < ch_t.length; r++) {
            swindow[ch_t[r]]++;
            while(isCover(swindow, twindow)) {
                if(res_R - res_L > r - l) {
                    res_R = r;
                    res_L = l;
                }
                swindow[ch_t[l]]--;
                l++;
            }
        }
        return res_L < 0 ? "" : s.substring(res_L, res_R + 1);
    }

    public static boolean isCover(int[] swindow, int[] twindow) {
        for(int i = 'a'; i >= 'a' && i <= 'z'; i++) {
            if(swindow[i] < twindow[i]) return false;
        }
        for(int i = 'A'; i >= 'A' && i <= 'Z'; i++) {
            if(swindow[i] < twindow[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(minWindow(s, t));
    }
}
