package BinaryTree;

import java.util.*;

public class diameterOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int res;
    public static int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    public static int dfs(TreeNode root) {
        if(root == null) return -1;
        int maxL = dfs(root.left) + 1;
        int maxR = dfs(root.right) + 1;

        res = Math.max(res, maxL + maxR);
        return Math.max(maxL, maxR);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        TreeNode root = buildTree(s);
        System.out.println(diameterOfBinaryTree(root));
    }

    public static TreeNode buildTree(String s) {
        if(s == null || s.isEmpty()) return null;
        String[] splits = s.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        int index = 1;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty() && index < splits.length) {
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
