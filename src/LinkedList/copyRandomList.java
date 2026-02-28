package LinkedList;

import java.util.*;

public class copyRandomList {
    public static class Node {
        int val;
        Node next;
        Node random;
        Node() {}
        Node(int x) {
            val = x;
            next = null;
            random = null;
        }
    }
    public static Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
