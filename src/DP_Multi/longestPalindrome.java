package DP_Multi;

import java.util.*;

public class longestPalindrome {

    public static String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;

        String res = s.substring(0, 1);

        for(int i = len - 1; i >= 0; i--) {
            for(int j = i; j < len; j++) {
                if(c[i] == c[j]) {
                    if(j - i <= 1) {
                        dp[i][j] = true;
                        int tmp = j - i + 1;
                        if(tmp > maxLen) {
                            maxLen = tmp;
                            res = s.substring(i, j + 1);
                        }
                    } else {
                        if(dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            int tmp = j - i + 1;
                            if(tmp > maxLen) {
                                maxLen = tmp;
                                res = s.substring(i, j + 1);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(longestPalindrome(s));
    }
}
