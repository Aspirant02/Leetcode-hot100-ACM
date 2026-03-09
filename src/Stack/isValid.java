package Stack;

import java.util.*;

public class isValid {

    public static boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') st.push(')');
            else if(str.charAt(i) == '[') st.push(']');
            else if(str.charAt(i) == '{') st.push('}');
            else if(st.isEmpty() || str.charAt(i) != st.peek()) return false;
            else st.pop();
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print(isValid(str));
    }
}
