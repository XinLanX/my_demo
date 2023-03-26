package com.xxl.mydemo.leetcode.easyTests;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class isValid {
    public static void main(String[] args) {
        String s = "(){";
        if (getStackValid(s)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
    public static boolean isValid(String s) {
//        Map<String , String > map = new HashMap<String, String>(){
//            {
//                put("(","1");
//                put(")","1");
//                put("[","2");
//                put("]","2");
//                put("{","3");
//                put("}","3");
//            }
//        };
//        Map<String , Integer > mapLast = new HashMap<String, Integer>(){
//            {
//                put("1",0);
//                put("2",0);
//                put("3",0);
//            }
//        };
//        for (int i = 0; i < s.length(); ++i){
//            String sub = String.valueOf(s.charAt(i));
//            String sChar = map.get(sub);
//            Integer num = mapLast.get(sChar);
//            num = num+1;
//            mapLast.replace(sChar, num);
//        }
//        if (mapLast.get("1")%2 != 0){
//            return false;
//        }
//        if (mapLast.get("2")%2 != 0){
//            return false;
//        }
//        if (mapLast.get("3")%2 != 0){
//            return false;
//        }
//        return true;
        Map<Character, Character> map = new HashMap<Character, Character>(){
            {
                put('(',')');
                put('{','}');
                put('[',']');
                put('?','?');
            }
        };
        if (s.length()>0 && !map.containsKey(s.charAt(0))){
            return false;
        }
        LinkedList<Character> stack = new LinkedList<Character>(){
            {
                add('?');
            }
        };
        for (Character c : s.toCharArray()){
            if (map.containsKey(c)) {
                stack.addLast(c);
            } else if (!map.get(stack.removeLast()).equals(c)){
                return false;
            }
        }
        return stack.size() == 1;
    }

    public static boolean officialSolution(String s){
        Map<Character, Character> map = new HashMap<Character, Character>(){
            {
                put('(',')');
                put('{','}');
                put('[',']');
                put('?','?');
            }
        };
        if (s.length()>0 && !map.containsKey(s.charAt(0))){
            return false;
        }
        LinkedList<Character> stack = new LinkedList<Character>(){
            {
                add('?');
            }
        };
        for (Character c : s.toCharArray()){
            if (map.containsKey(c)) {
                stack.addLast(c);
            } else if (!map.get(stack.removeLast()).equals(c)){
                return false;
            }
        }
        return stack.size() == 1;

    }

    public static boolean getStackValid(String s){
        if (s.isEmpty()){
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()){
            if (c.equals('{')){
                stack.push('}');
            }else if (c.equals('[')){
                stack.push('[');
            }else if (c.equals('(')){
                stack.push(')');
            }else if (stack.empty()|| !c.equals(stack.pop())){
                return false;
            }
        }
        return stack.empty();
    }
}
