package BackTracking;

import java.util.*;

public class letterCombinations {

    private static List<String> res;
    private static StringBuilder sb;
    public static List<String> letterCombinations(String str) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        if(str.length() == 0) return res;
        String[] nums = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtracking(str, nums, 0);
        return res;
    }

    public static void backtracking(String str, String[] nums, int start) {
        if(sb.length() == str.length()) {
            res.add(sb.toString());
            return;
        }
        String nums2 = nums[str.charAt(start) - '0'];
        for(int i = 0; i < nums2.length(); i++) {
            sb.append(nums2.charAt(i));
            backtracking(str, nums, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print(letterCombinations(str));
    }
}
