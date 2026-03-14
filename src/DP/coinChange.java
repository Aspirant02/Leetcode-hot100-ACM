package DP;

import java.util.*;

public class coinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++) dp[i] = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            for(int j = coins[i]; j <= amount; j++) {
                if(dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int amount = sc.nextInt();
        String[] splits = str.split(",");
        int[] coins = new int[splits.length];

        for(int i = 0; i < splits.length; i++) coins[i] = Integer.parseInt(splits[i]);
        System.out.println(coinChange(coins, amount));
    }
}
