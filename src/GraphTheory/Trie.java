package GraphTheory;

import java.util.*;

public class Trie {
    public static class TrieNode {
        TrieNode[] son;
        boolean end;
        TrieNode() {
            son = new TrieNode[26];
            end = false;
        }
    }

    public static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static void insert(String s) {
        TrieNode cur = root;
        for(char c : s.toCharArray()) {
            c -= 'a';
            if(cur.son[c] == null) {
                cur.son[c] = new TrieNode();
            }
            cur = cur.son[c];
        }
        cur.end = true;
    }

    public static boolean search(String s) {
        return find(s) == 2;
    }

    public static boolean startsWith(String s) {
        return find(s) != 0;
    }

    public static int find(String s) {
        TrieNode cur = root;
        for(char c : s.toCharArray()) {
            c -= 'a';
            if(cur.son[c] == null) return 0;
            cur = cur.son[c];
        }
        return cur.end ? 2 : 1;
    }

    public static void main(String[] args) {

    }
}
