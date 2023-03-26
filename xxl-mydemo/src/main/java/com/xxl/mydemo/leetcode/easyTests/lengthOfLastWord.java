package com.xxl.mydemo.leetcode.easyTests;

public class lengthOfLastWord {
    public static void main(String[] args) {
        String s = " asda dsa moon";
        System.out.println(lengthOfLastWord(s));
    }

    private static int lengthOfLastWord(String s){
        int len = s.length();
        int right = len;
        int left = 0;
        int flag = 0;
        for (int i = len-1; i >= 0; --i){
            if (s.charAt(i) == ' ' && flag == 0){
                right--;
            }else if (s.charAt(i) == ' ' && flag == 1){
                left = i+1;
                break;
            }else {
                flag = 1;
            }
        }
        return right-left;
    }
    private static int lengthOfLastWord1(String s){
        while (s.endsWith(" ")){
            s = s.substring(0, s.length()-1);
        }
//        s=s.substring(s.lastIndexOf(" ")+1);
        return s.length()-s.lastIndexOf(" ")-1;
    }
    private static int officialLengthOfLastWord1(String s){
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if(end < 0) {
            return 0;
        }
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }
    private static int officialLengthOfLastWord2(String s){
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }
}
