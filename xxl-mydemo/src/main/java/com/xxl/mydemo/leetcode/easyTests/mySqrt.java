package com.xxl.mydemo.leetcode.easyTests;

public class mySqrt {
    public static void main(String[] args) {
        int x = 5;
        System.out.println(officialMySqrit1(x));
    }

    private static int mySqrit(int x){
        if (x == 1){
            return 1;
        }
        double xx = (double) x;
        double i = 1;
        while (i > 0){
            if (i*i < xx){
                i++;
            }else if(i*i == xx) {
                return (int)i;
            }else {
                return (int)--i;
            }
        }
        return (int)i;
    }

    private static int officialMySqrit1(int x){
        int l = 0;
        int r = x;
        int res = -1;
        while (l <= r){
            int mid = l + (r-l)/2;
            if((long)mid*mid <= x){
                res = mid;
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return res;
    }
}
