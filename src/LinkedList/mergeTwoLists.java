package LinkedList;

import java.util.*;

public class mergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        if(head1.val < head2.val) {
            head1.next = mergeTwoLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoLists(head1, head2.next);
            return head2;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String l1 = sc.nextLine();
        String l2 = sc.nextLine();

        ListNode head1 = buildList(l1);
        ListNode head2 = buildList(l2);

        ListNode res = mergeTwoLists(head1, head2);

        if(res == null) System.out.println("[]");
        else {
            while (res != null) {
                System.out.print(res.val + " ");
                res = res.next;
            }
        }
    }

    public static ListNode buildList(String str) {
        // 1. 处理空字符串的情况（如果是空，直接返回 null 表示空链表）
        if (str == null || str.isEmpty()) {
            return null;
        }

        // 2. 正常分割并构建链表
        String[] splits = str.split(",");
        ListNode head = new ListNode(Integer.parseInt(splits[0]));
        ListNode cur = head;

        for (int i = 1; i < splits.length; i++) {
            cur.next = new ListNode(Integer.parseInt(splits[i]));
            cur = cur.next;
        }
        return head;
    }
}
