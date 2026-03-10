package Stack;

import java.util.*;

public class decodeString {

    public static String decodeString(String s) {
        int multi = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st1 = new Stack<>();
        Stack<String> st2 = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '[') {
                st1.push(multi);
                st2.push(sb.toString());
                multi = 0;
                sb = new StringBuilder();
            } else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int tmp_multi = st1.pop();
                for(int i = 0; i < tmp_multi; i++) {
                    tmp.append(sb);
                }
                sb = new StringBuilder(st2.pop() + tmp);
            } else if(c >= '0' && c <= '9') {
                multi = multi * 10 + (c - '0');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print(decodeString(str));
    }
}
