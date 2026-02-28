package LinkedList;

import java.util.*;

public class sortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode res = new ListNode(0);
        ListNode tmp2 = res;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        while(left != null & right != null) {
            if(left.val < right.val) {
                tmp2.next = left;
                left = left.next;
                tmp2 = tmp2.next;
            } else {
                tmp2.next = right;
                right = right.next;
                tmp2 = tmp2.next;
            }
        }
        tmp2.next = left == null ? right : left;
        return res.next;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ListNode head = buildList(s);
        ListNode res = sortList(head);
        if(res == null) System.out.println("[]");
        else {
            while(res != null) {
                System.out.print(res.val + " ");
                res = res.next;
            }
        }
    }
    public static ListNode buildList(String s) {
        if(s == null || s.isEmpty()) return null;
        String[] splits = s.split(",");
        ListNode head = new ListNode(Integer.parseInt(splits[0]));
        ListNode cur = head;
        for(int i = 1; i < splits.length; i++) {
            cur.next = new ListNode(Integer.parseInt(splits[i]));
            cur = cur.next;
        }
        return head;
    }
}
