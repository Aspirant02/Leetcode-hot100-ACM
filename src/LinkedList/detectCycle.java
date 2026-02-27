package LinkedList;

import java.io.*;
import java.util.*;

public class detectCycle {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                while(head != fast) {
                    head = head.next;
                    fast = fast.next;
                }
                return head;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        ListNode head = new ListNode(Integer.parseInt(split[0]));
        ListNode cur = head;

        for(int i = 1; i < split.length; i++) {
            cur.next = new ListNode(Integer.parseInt(split[i]));
            cur = cur.next;
        }

        int pos = sc.nextInt();
        if(pos != -1) {
            ListNode tmp = head;
            while (pos-- > 0) {
                tmp = tmp.next;
            }
            cur.next = tmp;
        }
        System.out.println(detectCycle(head).val);

    }
}
