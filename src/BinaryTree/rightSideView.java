package BinaryTree;

import java.util.*;

public class rightSideView {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root == null) return res;

        que.offer(root);
        while(!que.isEmpty()) {
            int n = que.size();
            while(n -- > 0) {
                TreeNode cur = que.poll();
                if(n == 0) res.add(cur.val);

                if(cur.left != null) que.offer(cur.left);
                if(cur.right != null) que.offer(cur.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        TreeNode root = buildTree(s);
        System.out.println(rightSideView(root));
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
