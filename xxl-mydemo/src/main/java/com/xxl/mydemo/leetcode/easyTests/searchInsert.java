package com.xxl.mydemo.leetcode.easyTests;

public class searchInsert {
    public static void main(String[] args) {

    }

    private static int searchInsert(int[] nums, int target){
        int len = nums.length;
        for (int i = 0; i < len; ++i){
            if (nums[i] == target){
                return i;
            }
        }
        for (int i = 0; i < len; ++i){
            if (target < nums[i]){
                return i;
            }
        }
        return len+1;
    }

    private static int officialSearchInsert(int[] nums, int target){
        int len = nums.length;
        if (nums[len-1]<target){
            return len;
        }
        int left = 0;
        int right = len - 1;
        while (left < right){
            int mid = (left + right)/2;
            if (nums[mid] < target){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;

    }
}
