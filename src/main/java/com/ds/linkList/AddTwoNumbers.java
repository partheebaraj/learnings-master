package com.ds.linkList;

import com.ds.linkList.ListNode;

import java.util.Arrays;

public class AddTwoNumbers {

    public static void main(String[] args) {
        //ListNode l1= createList(Arrays.asList(9));
        //ListNode l2= createList(Arrays.asList(1,9,9,9,9,9,9,9,9,9));
       //ListNode l1= createList(Arrays.asList(2,4,3));
        ListNode l2= ListNode.createList(Arrays.asList(5,6,4,7,8));

        ListNode l1= ListNode.createList(Arrays.asList(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1));

        //ListNode l3 = addContentsInList(l1,l2);
        //ListNode.printList(l3);
        ListNode.reversePrintList(l2);


    }






    private static ListNode addContentsInList(ListNode l1, ListNode l2) {

        ListNode root = null;
        ListNode tempNode = null;
        if(l1==null && l2 == null) {
            return new ListNode(0);
        }
        else if(l1==null) {
            return ListNode.reverse(l2);
        } else if(l2==null) {
            return ListNode.reverse(l1);
        }

        int previous =0;
        while (l1!=null && l2!=null) {
            int sum = l1.val+l2.val+previous;
            previous = 0;
            int val = sum;
            if(sum > 9) {
                val = sum%10;
                previous ++;
            }
            if(root == null) {
                root = new ListNode(val);
                tempNode = root;

            }else {
                tempNode.next = new ListNode(val);
                tempNode = tempNode.next;
            }
            l1=l1.next;
            l2=l2.next;
        }

        while (l1!=null) {
            int sum = l1.val+previous;
            previous = 0;
            int val = sum;
            if(sum > 9) {
                val = sum%10;
                previous ++;
            }
                tempNode.next = new ListNode(val);
                tempNode = tempNode.next;

            l1=l1.next;
        }

        while (l2!=null) {
            int sum = l2.val+previous;
            previous = 0;
            int val = sum;
            if(sum > 9) {
                val = sum%10;
                previous ++;
            }
            tempNode.next = new ListNode(val);
            tempNode = tempNode.next;

            l2=l2.next;
        }
        if(previous >0) {
            tempNode.next = new ListNode(previous);

        }
        return root;
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long n1 =   getIntValue(l1);
        long n2 =   getIntValue(l2);

        long temp = n1+n2;
        if(temp ==0) {
            return new ListNode(0);
        }
        ListNode root = null;
        ListNode tempNode = null;
        while(temp >0) {
            int digit = new Long(temp%10).intValue();
            temp = temp/10;
            if(root==null){
                root = new ListNode(digit);
                tempNode = root;
            } else {
                tempNode.next = new ListNode(digit);
                tempNode = tempNode.next;
            }
        }

        return root;
    }

    private static Long getIntValue(ListNode l) {
        long value =0L;
        int index =0;
        while(l!=null) {
            value= value + new Double(l.val*Math.pow(10,index)).longValue();
            index++;
            l = l.next;
        }
        return value;
    }
}


