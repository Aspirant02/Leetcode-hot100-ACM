package DP;

import java.util.*;

public class generate {
    public static List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j != 0 && j != i) {
                    tmp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                } else tmp.add(1);
            }
            res.add(tmp);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(generate(n));
    }
}
