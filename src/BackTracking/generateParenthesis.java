package BackTracking;

import java.util.*;

public class generateParenthesis {

    private static List<String> res;
    private static StringBuilder sb;
    public static List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        int left = 0, right = 0;
        backtracking(left, right, n);
        return res;
    }

    public static void backtracking(int left, int right, int n) {
        if(left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        if(left < n) {
            sb.append('(');
            backtracking(left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < left) {
            sb.append(')');
            backtracking(left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(generateParenthesis(n));
    }
}
