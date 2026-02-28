package LinkedList;

import java.util.*;

public class reverseKGroup {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        for(ListNode cur = head; cur != null; cur = cur.next) n++;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode p0 = dummy;
        for(; n >= k; n -= k) {
            for(int i = 0; i < k; i++) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            ListNode tmp = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = tmp;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ListNode head = buildList(s);
        int k = sc.nextInt();
        ListNode res = reverseKGroup(head, k);
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
