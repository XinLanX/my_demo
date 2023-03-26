package com.xxl.mydemo.leetcode.easyTests;

import java.io.IOException;

public class plusOne {
    public static void main(String[] args) {
        int[] digits = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,9,9,9};
//        int[] digits = {9};
        int[] res = officialOnePlus(digits);
        for (int i = 0; i < res.length; ++i){
            System.out.print(res[i]);
        }
        System.out.println("\n"+res.length);
    }

    private static int[] plusOne(int[] digits){
        int len = digits.length;
        int flag = 0;
        int sit = 0;
        int top = 0;
        if (len == 1 && digits[0] == 9){
            int[] res = {1,0};
            return res;
        }
        for (int i = len-1; i >= 0; --i){
            if (digits[i] != 9 && i == len-1){
                digits[i] = digits[i]+1;
                break;
            }else if (digits[i] != 9) {
                if (flag == 1 && digits[i]<=8){
                    digits[i] = digits[i]+1;
                    for (int j = i; j < i+sit; ++j){
                        digits[j+1] = 0;
                    }
                    break;
//                    digits[i+1] = 0;
                }else {
                    top = 1;
                }
                flag = 0;
            } else if (digits[i] == 9 && i == 0 && flag == 1){
                top = 1;
            }else if (digits[i] == 9 && i != 0){
                flag = 1;
                sit++;
            }
        }
        if (top == 1){
            int[] res = new int[len+1];
            res[0] = 1;
            for (int i = 1; i < res.length; ++i){
                res[i] = 0;
            }
            return res;
        }else {
            int[] res = new int[len];
            System.arraycopy(digits, 0, res, 0, len);
            return res;
        }
    }

    private static int[] officialOnePlus(int[] digits){
        int len = digits.length;
        for (int i = len-1; i >= 0; --i){
            if (digits[i]==9){
                digits[i]=0;
            }else {
                digits[i] = digits[i]+1;
                return digits;
            }
        }
        digits = new int[len+1];
        digits[0]  =  1;
        return digits;
    }
}
