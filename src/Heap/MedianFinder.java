package Heap;

import java.util.*;

public class MedianFinder {
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    public MedianFinder() {
        pq1 = new PriorityQueue<>();
        pq2 = new PriorityQueue<>((a, b) -> (b - a));
    }

    public void addNum(int num) {
        if(pq1.size() != pq2.size()) {
            pq1.offer(num);
            pq2.offer(pq1.poll());
        } else {
            pq2.offer(num);
            pq1.offer(pq2.poll());
        }
    }

    public double findMedian() {
        return pq1.size() == pq2.size() ? (pq1.peek() + pq2.peek()) / 2.0 : pq1.peek();
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}
