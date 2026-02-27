package LinkedList;

import java.util.*;

public class removeNthFromEnd {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        n++;

        ListNode slow = dummy;
        ListNode fast = dummy;
        while(n -- > 0) {
            fast = fast.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        if(slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();

        ListNode head = buildList(s);
        ListNode res = removeNthFromEnd(head, n);

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
