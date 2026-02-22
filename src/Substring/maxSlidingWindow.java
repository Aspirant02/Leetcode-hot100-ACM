package Substring;

import java.io.*;
import java.util.*;

class Myque {
    Deque<Integer> que = new LinkedList<>();
    public int peek() {
        return que.peek();
    }

    public void offer(int val) {
        while(!que.isEmpty() && val > que.getLast()) {
            que.removeLast();
        }
        que.offer(val);
    }

    public void poll(int val) {
        if(!que.isEmpty() && que.peek() == val) {
            que.poll();
        }
    }
}
public class maxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Myque que = new Myque();
        for(int i = 0; i < k; i++) {
            que.offer(nums[i]);
        }

        int[] res = new int[nums.length - k + 1];
        res[0] = que.peek();

        for(int i = k; i < nums.length; i++) {
            que.poll(nums[i - k]);
            que.offer(nums[i]);
            res[i - k + 1] = que.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        String[] split = str.split(",");
        int[] nums = new int[split.length];

        for(int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
