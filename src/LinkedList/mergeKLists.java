package LinkedList;

import java.util.*;

public class mergeKLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> que = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for(ListNode head : lists) {
            if(head != null) que.offer(head);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!que.isEmpty()) {
            ListNode tmp = que.poll();
            cur.next = tmp;
            cur = cur.next;
            if(tmp.next != null) que.offer(tmp.next);
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode[] lists = new ListNode[n];
        sc.nextLine();
        for(int i = 0; i < n; i++) {
            String s = sc.nextLine();
            lists[i] = buildList(s);
        }
        ListNode res = mergeKLists(lists);
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
