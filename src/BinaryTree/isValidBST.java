package BinaryTree;

import java.util.*;

public class isValidBST {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
    }

    private static long max;

    public static boolean isValidBST(TreeNode root) {
        max = Long.MIN_VALUE;
        return dfs(root);
    }

    public static boolean dfs(TreeNode root) {
        if(root == null) return true;
        boolean left = dfs(root.left);

        if(max < root.val) {
            max = root.val;
        } else return false;

        boolean right = dfs(root.right);
        return left && right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        TreeNode root = buildTree(s);
        System.out.println(isValidBST(root));
    }

    public static TreeNode buildTree(String s) {
        if(s == null || s.isEmpty()) return null;
        String[] splits = s.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        int index = 1;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(index < splits.length && !que.isEmpty()) {
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
