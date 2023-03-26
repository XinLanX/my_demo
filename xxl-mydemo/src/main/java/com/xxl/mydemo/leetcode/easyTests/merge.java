package com.xxl.mydemo.leetcode.easyTests;

import java.util.Arrays;

public class merge {
    public static void main(String[] args) {
        int[] nums1 = {1,2,4,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

//        int a = 1;
//        int b = 2;
//        swap(a, b);
//        System.out.println(a+" "+b);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n){
        int k = 0;
        for (int i = m; i < m+n; ++i){
            nums1[i] = nums2[k++];
        }
//        for (int i = 0; i < m+n; ++i){
//            for (int j = i; j < m+n; ++j){\
//                if (nums1[i] > nums1[j]){
//
//                    swap(nums1[i], nums1[j]);
//                }
//            }
//        }
        Arrays.sort(nums1);
    }

    private static void swap(int a, int b){
        int swap = a;
        a = b;
        b = swap;
    }
}
