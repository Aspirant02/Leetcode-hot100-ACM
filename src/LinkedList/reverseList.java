package LinkedList;

import java.util.*;
import java.io.*;

public class reverseList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode reverseList(ListNode head) {
        return reverse(null, head);
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
        for(int i = 1; i < splits.length; i++) {
            cur.next = new ListNode(Integer.parseInt(splits[i]));
            cur = cur.next;
        }
        ListNode res = reverseList(head);
        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
