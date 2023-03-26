package com.xxl.mydemo.leetcode.easyTests;


public class mergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 ==  null){
            return list2;
        }
        else if (list2 ==  null){
            return list1;
        }else if (list1.val <  list2.val){
            list1.next  = mergeTwoLists(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeTwoLists(list1,  list2.next);
            return list2;
        }


    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode();
        n1.val = 1;
        ListNode n2 = new ListNode();
        n2.val = 2;
        ListNode n3 = new ListNode();
        n3.val = 3;
        ListNode listNode = new ListNode();
        listNode.val = 0;
        listNode.next = n1;
        listNode.next.next = n2;
        listNode.next.next.next  = n3;
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;

        }
    }
    public static ListNode  copyMerge(ListNode l1, ListNode l2){
        if (l1  == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if (l1.val < l2.val){
            l1.next = copyMerge(l1.next, l2);
            return l1;
        }else {
            l2.next = copyMerge(l1, l2.next);
            return l2;
        }
    }
}
