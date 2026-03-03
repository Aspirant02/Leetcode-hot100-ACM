package BinaryTree;

import java.util.*;

public class flatten {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void flatten(TreeNode root) {
        while(root != null) {
            if(root.left == null) {
                root = root.right;
            } else {
                TreeNode cur = root.left;
                while(cur.right != null) {
                    cur = cur.right;
                }
                cur.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        TreeNode root = buildTree(s);
        flatten(root);
        while(root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
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
