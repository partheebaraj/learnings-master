package com.ds.linkList;

import com.ds.linkList.ListNode;

import java.util.Arrays;

public class MergeTwoSortedList {

    public static void main(String[] args) {

        //ListNode l1= ListNode.createList(Arrays.asList(9));
        //ListNode l2= ListNode.createList(Arrays.asList(1,9,9,9,9,9,9,9,9,9));
        ListNode l1= ListNode.createList(Arrays.asList(2,3,4));
        ListNode l2= ListNode.createList(Arrays.asList(5,6,7));

        //ListNode l1= ListNode.createList(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1));

        ListNode l3 = mergeTwoLists(l1,l2);
        ListNode.printList(l3);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode tempNode = null;
        if(l1==null && l2 == null) {
            return null;
        }
        else if(l1==null) {
             return l2;
        } else if(l2==null) {
            return l1;
        }

        while(l1!=null && l2!=null) {

            if(l1.val <= l2.val) {
                if(root == null) {
                    root = new ListNode(l1.val);
                    tempNode = root;

                }else {
                    tempNode.next = new ListNode(l1.val);
                    tempNode = tempNode.next;
                }
                l1=l1.next;
            } else {
                if(root == null) {
                    root = new ListNode(l2.val);
                    tempNode = root;

                }else {
                    tempNode.next = new ListNode(l2.val);
                    tempNode = tempNode.next;
                }
                l2=l2.next;
            }
 }
// This code can be improved with better one
       /* while (l1!=null) {
            tempNode.next = new ListNode(l1.val);
            tempNode = tempNode.next;

            l1=l1.next;
        }
        while (l2!=null) {
            tempNode.next = new ListNode(l2.val);
            tempNode = tempNode.next;

            l2=l2.next;
        }*/

       if(null == l1 && l2==null) {
            return root;
       } else if(null == l1 ) {
           tempNode.next = l2;
           return root;
       } else {
           tempNode.next = l1;
           return root;
       }

      // return root;
    }

}


