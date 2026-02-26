package LinkedList;

import java.util.*;
import java.io.*;

public class getIntersectionNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;
        ListNode A = headA;
        ListNode B = headB;

        while(A != null) {
            sizeA++;
            A = A.next;
        }
        while (B != null) {
            sizeB++;
            B = B.next;
        }

        int diff = sizeA - sizeB;
        if(diff > 0) {
            while(diff-- > 0) {
                headA = headA.next;
            }
            while(headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        } else {
            while(diff++ < 0) {
                headB = headB.next;
            }
            while(headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }
    }
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;
        System.out.println(getIntersectionNode(headA, headB).val);
    }
}
