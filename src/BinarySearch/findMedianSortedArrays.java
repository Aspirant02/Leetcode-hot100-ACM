package BinarySearch;

import java.util.*;

public class findMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            int[] tmp = nums2;
            nums2 = nums1;
            nums1 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int[] a = new int[m + 2];
        int[] b = new int[n + 2];
        a[0] = b[0] = Integer.MIN_VALUE;
        a[m + 1] = b[n + 1] = Integer.MAX_VALUE;

        System.arraycopy(nums1, 0, a, 1, m);
        System.arraycopy(nums2, 0, b, 1, n);

        int left = 0, right = m + 1;
        while(left <= right) {
            int i = left + (right - left) / 2;
            int j = (m + n + 1) / 2 - i;
            if(a[i] <= b[j + 1]) left = i + 1;
            else right = i - 1;
        }

        int i = right;
        int j = (m + n + 1) / 2 - i;

        int max = Math.max(a[i], b[j]);
        int min = Math.min(a[i + 1], b[j + 1]);
        return (m + n) % 2 == 0 ? (max + min) / 2.0 : max * 1.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] splits1 = s1.split(",");
        String[] splits2 = s2.split(",");
        int[] nums1 = new int[splits1.length];
        int[] nums2 = new int[splits2.length];
        for(int i = 0; i < splits1.length; i++) nums1[i] = Integer.parseInt(splits1[i]);
        for(int i = 0; i < splits2.length; i++) nums2[i] = Integer.parseInt(splits2[i]);
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
