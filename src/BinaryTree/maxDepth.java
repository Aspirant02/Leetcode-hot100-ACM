package BinaryTree;

import java.util.*;

public class maxDepth {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public static int maxDepth(TreeNode root) {
        int res = 0;
        if(root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            int len = que.size();
            res++;
            while(len -- > 0) {
                TreeNode tmp = que.poll();
                if(tmp.left != null) que.offer(tmp.left);
                if(tmp.right != null) que.offer(tmp.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        TreeNode root = buildTree(s);
        System.out.println(maxDepth(root));
    }

    public static TreeNode buildTree(String s) {
        if(s == null || s.isEmpty()) return null;
        String[] splits = s.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int index = 1;

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
