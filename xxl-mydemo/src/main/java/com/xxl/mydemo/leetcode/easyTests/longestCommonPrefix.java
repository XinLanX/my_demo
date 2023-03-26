package com.xxl.mydemo.leetcode.easyTests;

import java.util.ArrayList;
import java.util.List;

public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        int minLen = strs[0].length();
        ArrayList<String> subStrs = new ArrayList<>();
        for (int i = 0;i < strs.length; ++i){
            subStrs.add("");
            int len = strs[i].length();
            if (len < minLen){
                minLen = len;
            }
        }
        int flag = 1;
        String subStr = "";
        for (int j = 0; j <= minLen; ++j){
            for (int k = 0; k < strs.length; k++){
                subStrs.set(k,strs[k].substring(0,j));
            }
            subStr = subStrs.get(0);
            for (int k = 1; k < strs.length; k++){

                if (subStrs.get(k).equals(subStr)){
                    continue;
                }else {
                    flag = 0;
                    break;
                }
            }
            if (flag == 0){
                break;
            }
        }
        if (flag == 1){
            return subStr;
        }else {
            return subStr.substring(0,subStr.length()-1);
        }
    }

    /**
     * 官解
     */
    public String officialSolution(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

}
