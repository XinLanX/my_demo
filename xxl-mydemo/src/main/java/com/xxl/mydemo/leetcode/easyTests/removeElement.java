package com.xxl.mydemo.leetcode.easyTests;

public class removeElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,1,3,2};
        int val = 3;
        int k = removeElement(nums, val);
        for (int i = 0; i < k; ++i){
            System.out.println(nums[i]);
        }
    }

    private static int removeElement(int[] nums, int val){
        int len = nums.length;
        int k = 0;
        for (int i = 0; i < len; ++i){
            if (nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
