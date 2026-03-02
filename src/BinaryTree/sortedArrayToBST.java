package BinaryTree;

import java.util.*;

public class sortedArrayToBST {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return func(nums, 0, nums.length - 1);
    }

    public static TreeNode func(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = func(nums, start, mid - 1);
        node.right = func(nums, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] splits = s.split(",");
        int[] nums = new int[splits.length];
        for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(splits[i]);
        TreeNode res = sortedArrayToBST(nums);
        System.out.println(levelOrder(res));
    }

    public static List<Integer> levelOrder(TreeNode root) {
        if(root == null) return null;
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            int n = que.size();
            while(n -- > 0) {
                TreeNode cur = que.poll();
                res.add(cur.val);

                if(cur.left != null) que.offer(cur.left);
                if(cur.right != null) que.offer(cur.right);
            }
        }
        return res;
    }
}
