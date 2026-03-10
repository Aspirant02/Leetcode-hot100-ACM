package Stack;

import java.awt.*;
import java.util.*;

public class dailyTemperatures {

    public static int[] dailyTemperatures(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] <= nums[st.peek()]) {
                st.push(i);
            } else {
                while(!st.isEmpty() && nums[i] > nums[st.peek()]) {
                    res[st.peek()] = i - st.peek();
                    st.pop();
                }
                st.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] splits = s.split(",");
        int[] nums = new int[splits.length];
        for(int i = 0; i < splits.length; i++) nums[i] = Integer.parseInt(splits[i]);

        System.out.println(Arrays.toString(dailyTemperatures(nums)));
    }
}
