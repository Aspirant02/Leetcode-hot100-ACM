package Greedy;

import java.util.*;

public class partitionLabels {

    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] hash = new int[26];
        for(int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i;
        }
        int start = -1, end = 0;
        for(int i = 0; i < s.length(); i++) {
            end = Math.max(hash[s.charAt(i) - 'a'], end);
            if(i == end) {
                res.add(i - start);
                start = end;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(partitionLabels(s));
    }
}
