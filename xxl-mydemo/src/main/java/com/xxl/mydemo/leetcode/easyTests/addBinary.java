package com.xxl.mydemo.leetcode.easyTests;

public class addBinary {
    public static void main(String[] args) {
        String a = "11";
        String b = "110";
        System.out.println(officalAddBinary(a, b));
    }

    private static void addBinary(String a, String b){
//        int alen = a.length();
//        int blen = b.length();
//        int len = Integer.min(alen, blen);
//        char[] aChar = a.toCharArray();
//        char[] bChar = b.toCharArray();
//        int nextFlag = 0;
//        int flag = 0;
//        for (int i = len-1; i >= 0; --i){
//            nextFlag  =  flag;
//            if (nextFlag  ==  1  && aChar[i] == '1' &&  bChar[i] == '1' ){
//                aChar[i]=  '1';
//            }else if (nextFlag  ==  1  && aChar[i] == '0' &&  bChar[i] == '0'){
//                aChar[i] = '1';
//            }else {
//                aChar[i] = '0';
//            }
//            if (aChar[i] == '1' && bChar[i] == '1'){
//                aChar[i] = '0';
//                flag = 1;
//            }else if (aChar[i] ==  '0' &&  bChar[i] == '0'){
//                aChar[i] = '0';
//            }else {
//                aChar[i] = '1';
//            }
//        }

    }

    private static String officalAddBinary(String a, String b){
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 && j >= 0){
            int sum = carry;
            sum += a.charAt(i--) - '0';
            sum += b.charAt(j--) - '0';
            carry = sum/2;
            builder.append(sum%2);
        }
        while (i >= 0){
            int sum = carry;
            sum += a.charAt(i--) - '0';
            carry = sum/2;
            builder.append(sum%2);
        }
        while (j >= 0){
            int sum = carry;
            sum += b.charAt(j--) - '0';
            carry = sum/2;
            builder.append(sum%2);
        }
        if (carry == 1){
            builder.append(carry);
        }
        return builder.reverse().toString();
    }
}
