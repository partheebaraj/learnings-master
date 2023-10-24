package com.ds.linkList;

import java.util.Arrays;

public class HasCycle {

    public static void main(String[] args) {
        ListNode list= ListNode.createList(Arrays.asList(1,2,3,4,5));
       // printList(list);
        System.out.println(hasCycle(list));

    }

    static boolean hasCycle(ListNode node) {
        ListNode slowPointer=node;
        ListNode fasterPointer=node;

        while(fasterPointer!=null) {
            slowPointer = slowPointer.next;
            if(fasterPointer.next!=null) {
                fasterPointer = fasterPointer.next.next;
            } else {
                fasterPointer = null;
            }
            if(fasterPointer != null &&  slowPointer==fasterPointer){
                return true;
            }
        }

        return false;
    }
}
