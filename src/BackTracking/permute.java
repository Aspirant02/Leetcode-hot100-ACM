package BackTracking;

import java.util.*;

public class permute {

    private static List<List<Integer>> res;
    private static LinkedList<Integer> path;
    public static List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        backtracking(nums);
        return res;
    }

    public static void backtracking(int[] nums) {
        if(path.size() == nums.length) res.add(new ArrayList<>(path));
        for(int i = 0; i < nums.length; i++) {
            if(path.contains(nums[i])) continue;
            path.add(nums[i]);
            backtracking(nums);
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
        System.out.print(permute(nums));
    }
}
