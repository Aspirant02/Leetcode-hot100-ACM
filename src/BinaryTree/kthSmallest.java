package BinaryTree;

import java.util.*;

public class kthSmallest {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        int res = 0;

        while(cur != null || !st.isEmpty()) {
            if(cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                cur = st.pop();
                res++;
                if(res == k) return cur.val;
                cur = cur.right;
            }
        }
        return cur.val;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        TreeNode root = buildTree(s);
        int k = sc.nextInt();
        System.out.println(kthSmallest(root, k));
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
