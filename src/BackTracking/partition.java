package BackTracking;

import java.util.*;

public class partition {

    private static List<List<String>> res;
    private static LinkedList<String> path;
    public static List<List<String>> partition(String s) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        int start = 0;
        backtracking(s, new StringBuilder(), start);
        return res;
    }

    public static void backtracking(String s, StringBuilder sb, int start) {
        if(start == s.length()) res.add(new ArrayList<>(path));
        for(int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if(check(sb)) {
                path.add(sb.toString());
                backtracking(s, new StringBuilder(), i + 1);
                path.removeLast();
            }
        }
    }

    public static boolean check(StringBuilder sb) {
        for(int i = 0; i < sb.length() / 2; i++) {
            if(sb.charAt(i) != sb.charAt(sb.length() - i - 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(partition(s));
    }
}
