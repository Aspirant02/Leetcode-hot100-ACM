package BinaryTree;

import java.util.*;

public class maxPathSum {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int res;
    public static int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }

    public static int dfs(TreeNode root) {
        if(root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);

        res = Math.max(l + r + root.val, res);
        return Math.max(Math.max(l, r) + root.val, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        TreeNode root = buildTree(s);
        System.out.print(maxPathSum(root));
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
