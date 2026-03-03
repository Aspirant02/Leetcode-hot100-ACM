package BinaryTree;

import java.util.*;

public class pathSum {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int res;
    public static int pathSum(TreeNode root, int target) {
        res = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        func(root, 0L, target, map);
        return res;
    }

    public static void func(TreeNode root, long s, int target, Map<Long, Integer> map) {
        if(root == null) return;
        s += root.val;
        if(map.containsKey(s - target)) {
            res += map.get(s - target);
        }
        map.put(s, map.getOrDefault(s, 0) + 1);
        func(root.left, s, target, map);
        func(root.right, s, target, map);
        map.put(s, map.get(s) - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        TreeNode root = buildTree(s);
        int target = sc.nextInt();
        System.out.print(pathSum(root, target));
    }

    public static TreeNode buildTree(String s) {
        if(s == null || s.isEmpty()) return null;

        String[] splits = s.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        int index = 1;
        while (index < splits.length && !que.isEmpty()) {
            TreeNode cur = que.poll();

            if(index < splits.length && !splits[index].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(splits[index]));
                que.offer(cur.left);
            }
            index++;

            if(index < splits.length && !splits[index].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(splits[index]));
                que.offer(cur.right);
            }
            index++;
        }
        return root;
    }
}
