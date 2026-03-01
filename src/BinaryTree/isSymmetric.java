package BinaryTree;

import java.util.*;

public class isSymmetric {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root.left);
        que.offer(root.right);

        while(!que.isEmpty()) {
            TreeNode l = que.poll();
            TreeNode r = que.poll();
            if(l == null && r == null) continue;
            if(l == null || r == null || l.val != r.val) return false;
            que.offer(l.left);
            que.offer(r.right);
            que.offer(l.right);
            que.offer(r.left);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        TreeNode root = buildTree(s);
        System.out.println(isSymmetric(root));
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
