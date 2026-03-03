package BinaryTree;

import java.util.*;

public class buildTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return func(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public static TreeNode func(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if(preL == preR) return null;
        TreeNode root = new TreeNode(preorder[preL]);
        int i;
        for(i = inL; i < inR; i++) {
            if(inorder[i] == preorder[preL]) break;
        }

        int in1L = inL;
        int in1R = i;
        int in2L = i + 1;
        int in2R = inR;

        int pre1L = preL + 1;
        int pre1R = pre1L + (in1R - in1L);
        int pre2L = pre1R;
        int pre2R = preR;

        root.left = func(preorder, pre1L, pre1R, inorder, in1L, in1R);
        root.right = func(preorder, pre2L, pre2R, inorder, in2L, in2R);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int[] preorder = buildArray(s1);
        int[] inorder = buildArray(s2);
        TreeNode root = buildTree(preorder, inorder);
        System.out.print(levelOrder(root));
    }

    public static int[] buildArray(String s) {
        String[] splits = s.split(",");
        int[] res = new int[splits.length];
        for(int i = 0; i < splits.length; i++) {
            res[i] = Integer.parseInt(splits[i]);
        }
        return res;
    }

    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int n = que.size();

            while(n -- > 0) {
                TreeNode cur = que.poll();
                res.add(cur.val);
                if(cur.left != null) {
                    que.offer(cur.left);
                }
                if(cur.right != null) {
                    que.offer(cur.right);
                }
            }

        }
        return res;
    }
}
