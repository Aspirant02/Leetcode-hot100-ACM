package BinaryTree;

import com.sun.source.tree.Tree;

import java.util.*;

public class lowestCommonAncestor {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        else if(left == null && right != null) return right;
        else if(left != null && right == null) return left;
        else return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        TreeNode root = buildTree(s);
        int p = sc.nextInt();
        TreeNode nodeP = findNode(root, p);
        int q = sc.nextInt();
        TreeNode nodeQ = findNode(root, q);
        System.out.print(lowestCommonAncestor(root, nodeP, nodeQ).val);
    }

    public static TreeNode findNode(TreeNode root, int val) {
        if(root == null || root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        TreeNode right = findNode(root.right, val);
        return left == null ? right : left;
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
