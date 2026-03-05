package GraphTheory;

import java.util.*;

public class canFinish {

    public static boolean canFinish(int numCourses, int[][] nums) {
        List<List<Integer>> adjency = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            adjency.add(new ArrayList<>());
        }
        int[] degree = new int[numCourses];

        for(int i = 0; i < nums.length; i++) {
            degree[nums[i][0]]++;
            adjency.get(nums[i][1]).add(nums[i][0]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(degree[i] == 0) que.offer(i);
        }

        while(!que.isEmpty()) {
            int e = que.poll();
            numCourses--;

            int n = adjency.get(e).size();
            for(int i = 0; i < n; i++) {
                if(--degree[adjency.get(e).get(i)] == 0) {
                    que.offer(adjency.get(e).get(i));
                }
            }
        }
        return numCourses == 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCourses = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        int[][] nums = new int[n][2];
        for(int i = 0; i < n; i++) {
            String s = sc.nextLine();
            nums[i][0] = s.charAt(0) - '0';
            nums[i][1] = s.charAt(1) - '0';
        }
        System.out.println(canFinish(numCourses, nums));
    }
}
