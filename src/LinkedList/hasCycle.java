package LinkedList;

import java.util.*;
import java.io.*;

public class hasCycle {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
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
        int pos = sc.nextInt();
        if(pos != -1) {
            ListNode end = head;
            while (end.next != null) {
                end = end.next;
            }
            ListNode tmp = head;
            while (pos-- > 0) {
                tmp = tmp.next;
            }
            end.next = tmp;
        }
        System.out.println(hasCycle(head));
    }
}
