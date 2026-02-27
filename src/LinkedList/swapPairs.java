package LinkedList;

import java.util.Scanner;

public class swapPairs {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null ){
            ListNode tmp1 = cur.next;
            ListNode tmp2 = cur.next.next;
            ListNode tmp3 = cur.next.next.next;
            cur.next.next.next = tmp1;
            cur.next.next = tmp3;
            cur.next = tmp2;
            cur = cur.next.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        ListNode head = buildList(s);
        ListNode res = swapPairs(head);

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
