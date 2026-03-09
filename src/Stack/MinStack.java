package Stack;

import java.util.*;

public class MinStack {

    private Stack<Integer> st;
    private Stack<Integer> min_st;
    public MinStack() {
        st = new Stack<>();
        min_st = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        if(min_st.isEmpty() || min_st.peek() >= val) min_st.push(val);
    }

    public void pop() {
        if(st.pop().equals(min_st.peek())) min_st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min_st.peek();
    }

    public static void main(String[] args) {
        List<Object> res = new ArrayList<>();

        MinStack ms = new MinStack();
        res.add(null);

        ms.push(-2);
        res.add(null);

        System.out.print(res);
    }

}
