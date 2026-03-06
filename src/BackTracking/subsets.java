package BackTracking;

import java.util.*;

public class subsets {

    private static List<List<Integer>> res;
    private static LinkedList<Integer> path;
    public static List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        backtracking(nums, 0);
        return res;
    }

    public static void backtracking(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        int[] nums = new int[split.length];
        for(int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.print(subsets(nums));
    }
}
