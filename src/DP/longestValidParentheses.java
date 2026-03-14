package DP;

import java.util.*;

public class longestValidParentheses {

    public static int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        char[] c = s.toCharArray();

        int res = 0;
        for(int i = 1; i < s.length(); i++) {
            if(c[i] == ')') {
                int pre = i - dp[i - 1] - 1;
                if(pre >= 0 && c[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print(longestValidParentheses(str));
    }
}
