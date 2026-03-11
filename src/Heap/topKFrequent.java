package Heap;

import java.util.*;

public class topKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(var x : map.entrySet()) {
            int[] tmp = new int[2];
            tmp[0] = x.getKey();
            tmp[1] = x.getValue();
            pq.offer(tmp);
            if(pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splits = str.split(",");
        int k = sc.nextInt();
        int[] nums = new int[splits.length];

        for(int i = 0; i < splits.length; i++) nums[i] = Integer.parseInt(splits[i]);
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
