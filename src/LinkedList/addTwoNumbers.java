package LinkedList;

import java.util.*;

public class addTwoNumbers {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {val = x;}
        ListNode(int x, ListNode node) {
            val = x;
            next = node;
        }
    }
    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        return func(head1, head2, 0);
    }
    public static ListNode func(ListNode head1, ListNode head2, int carry) {
        if(head1 == null && head2 == null && carry == 0) {
            return null;
        }
        if(head1 != null) {
            carry += head1.val;
            head1 = head1.next;
        }

        if(head2 != null) {
            carry += head2.val;
            head2 = head2.next;
        }

        return new ListNode(carry % 10, func(head1, head2, carry / 10));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String l1 = sc.nextLine();
        String l2 = sc.nextLine();

        ListNode head1 = buildList(l1);
        ListNode head2 = buildList(l2);

        ListNode res = addTwoNumbers(head1, head2);
        if(res == null) {
            System.out.println("[]");
        } else {
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
