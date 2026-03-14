package DP;

import java.util.*;

public class wordBreak {

    public static boolean wordBreak(String s, List<String> words) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(String word : words) {
                if(i >= word.length() && dp[i - word.length()] && word.equals(s.substring(i - word.length(), i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        List<String> words = new ArrayList<>();
        for(int i = 0; i < n; i++) words.add(sc.nextLine());
        System.out.println(wordBreak(s, words));
    }
}
