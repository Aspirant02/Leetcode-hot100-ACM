package LinkedList;

import java.util.*;
import java.io.*;

public class isPalindrome {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode head2 = reverse(null, mid);
        while (head2 != null) {
            if(head2.val != head.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    public static ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode pre, ListNode cur) {
        if(cur == null) return pre;
        ListNode tmp = cur.next;
        cur.next = pre;
        return reverse(cur, tmp);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splits = str.split(",");
        ListNode head = new ListNode(Integer.parseInt(splits[0]));
        ListNode cur = head;
        for (int i = 1; i < splits.length; i++) {
            cur.next = new ListNode(Integer.parseInt(splits[i]));
            cur = cur.next;
        }
        System.out.println(isPalindrome(head));
    }
}
