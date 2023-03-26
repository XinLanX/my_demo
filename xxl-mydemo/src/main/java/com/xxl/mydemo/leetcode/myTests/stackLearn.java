package com.xxl.mydemo.leetcode.myTests;

import java.util.Stack;

public class stackLearn {
    public static void main(String[] args) {
//        Stack<String> stack =  new Stack<>();
//        stack.add("hello");
//        stack.add("world");
//
//        System.out.println(stack.push("world"));
//        System.out.println(stack.pop());
//        System.out.println(stack);
        String gitUrl = "//testgroup/test";
        if (gitUrl.startsWith("/")){
            gitUrl = gitUrl.substring(1);
        }
        System.out.println(gitUrl);
    }

    public void test1(){
        StringBuffer sb = new StringBuffer();
// 超过 120 个字符的情况下，换行缩进 4 个空格，点号和方法名称一起换行
        sb.append("zi")
            .append("xin")
            .append("huang")
            .append("huang")
            .append("huang");

    }
}
