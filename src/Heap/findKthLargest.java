package Heap;

import java.util.*;

public class findKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        for(int i = k; i < nums.length; i++) {
            if(nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splits = str.split(",");
        int k = sc.nextInt();
        int[] nums = new int[splits.length];

        for(int i = 0; i < splits.length; i++) nums[i] = Integer.parseInt(splits[i]);
        System.out.println(findKthLargest(nums, k));
    }
}
