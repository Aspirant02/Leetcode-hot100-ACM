package DP_Multi;

import java.util.*;

public class longestCommonSubsequence {

    public static int longestCommonSubsequence(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.print(longestCommonSubsequence(s1, s2));
    }
}
