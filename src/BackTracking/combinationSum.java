package BackTracking;

import java.util.*;

public class combinationSum {

    private static List<List<Integer>> res;
    private static LinkedList<Integer> path;
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        Arrays.sort(nums);
        int sum = 0, start = 0;
        backtracking(nums, target, sum, start);
        return res;
    }

    public static void backtracking(int[] nums, int target, int sum, int start) {
        if(target == sum) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < nums.length; i++) {
            if(target < sum + nums[i]) return;
            path.add(nums[i]);
            backtracking(nums, target, sum + nums[i], i);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splits = str.split(",");
        int[] nums = new int[splits.length];

        for(int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(splits[i]);
        }
        int target = sc.nextInt();
        System.out.print(combinationSum(nums, target));
    }
}
