package com.xxl.mydemo.leetcode.easyTests;

public class removeDuplicates {
    public static void main(String[] args) {
        int[] nums ={0,0,1,1,3,3,3,4,5,5,5} ;
        int[] expectedNums = {0,1,3,4,5};

        int k = removeDuplicatess(nums);

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
//            assert nums[i] == expectedNums[i];
            System.out.println(nums[i]);
        }
    }

    private static int removeDuplicates(int[] nums){
        int len  = nums.length;
        if (len <= 1){
            return len;
        }
        int result = 1;
        int up  =  1;
        int slow = 1;
        for (int i = 1; i < nums.length; ++i){
            if (nums[i]  != nums[i-1]){
                nums[up] =  nums[i];
                up++;
            }
        }
        return up;
    }



    private static int removeDuplicatess(int[] nums) {
        int len = nums.length;
        if (len<=1){
            return len;
        }
        int i = 1;
        for (int k = 1; k < nums.length; ++k){
            if (nums[k-1] < nums[k]){
                nums[i] = nums[k];
                i++;
            }
        }
        return i;
    }




























}
