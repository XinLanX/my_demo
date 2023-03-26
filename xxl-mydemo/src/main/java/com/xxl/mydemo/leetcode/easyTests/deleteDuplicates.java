package com.xxl.mydemo.leetcode.easyTests;

public class deleteDuplicates {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 1;
        ListNode listNode1 = new ListNode();
        listNode.next = listNode1;
        listNode.next.val = 1;
        ListNode listNode2 = new ListNode();
        listNode.next.next = listNode2;
        listNode.next.next.val = 2;
        ListNode listNode3 = new ListNode();
        listNode.next.next.next = listNode3;
        listNode.next.next.next.val = 3;
        ListNode listNode4 = new ListNode();
        listNode.next.next.next.next= listNode4;
        listNode.next.next.next.next.val = 3;
//        while (listNode.val != 0){
//            System.out.println(listNode.val);
//            if (listNode.next != null){
//                listNode = listNode.next;
//            }else {
//                break;
//            }
//        }
        ListNode myNode = deleteDuplicates(listNode);
        while (myNode.val != 0){
            System.out.println(myNode.val);
            if (myNode.next != null){
                myNode = myNode.next;
            }else {
                break;
            }
        }

    }

    private static ListNode deleteDuplicates(ListNode head){
        if (head == null){
            return head;
        }
        ListNode myNode = head;
        while (myNode.next != null){
            if (myNode.val == myNode.next.val){
                myNode.next = myNode.next.next;
            }else {
                myNode = myNode.next;
            }
        }
        return head;
    }
}
