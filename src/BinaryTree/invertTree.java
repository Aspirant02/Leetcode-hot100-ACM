package BinaryTree;

import java.util.*;

public class invertTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            int n = que.size();
            while(n -- > 0) {
                TreeNode tmp = que.poll();
                swap(tmp);
                if(tmp.left != null) que.offer(tmp.left);
                if(tmp.right != null) que.offer(tmp.right);
            }
        }
        return root;
    }

    public static void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        TreeNode root = buildTree(s);
        System.out.println(leverOrder(invertTree(root)));
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

    public static List<Integer> leverOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            int n = que.size();
            while(n -- > 0) {
                TreeNode tmp = que.poll();
                res.add(tmp.val);

                if(tmp.left != null) que.offer(tmp.left);
                if(tmp.right != null) que.offer(tmp.right);
            }
        }
        return res;
    }

}
