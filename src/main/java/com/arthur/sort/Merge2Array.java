package com.arthur.sort;

import org.junit.Test;

import java.util.Arrays;

public class Merge2Array {
    @Test
    public void testMerge() {
        int[] arr1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] arr2 = new int[]{2, 5, 6};
        merge(arr1, 3, arr2, 3);

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int l = m - 1;
        int r = n - 1;
        for (int i = m + n - 1; i > 0; i--) {
            if (r == -1) {
                nums1[i] = nums1[l--];
                continue;
            }

            if (l == -1 || nums1[l] < nums2[r]) {
                nums1[i] = nums2[r--];
                continue;
            }
            nums1[i] = nums1[l--];
        }

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}
