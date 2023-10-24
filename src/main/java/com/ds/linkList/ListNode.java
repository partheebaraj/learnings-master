package com.ds.linkList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static void main(String[] args) {
        ListNode list= ListNode.createList(Arrays.asList(5,6,4,7,8));
        list = reverseRecursively(list,list);
        printList(list);

    }

    public static ListNode reverse(ListNode listNode) {

        ListNode currentNode;
        ListNode previousNode =null;
        ListNode nextNode =listNode.next;
        currentNode = listNode;
        while(currentNode!=null) {
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            if(nextNode != null) {
                nextNode = nextNode.next;
            }
        }
        return previousNode;
    }

    private static ListNode reverseRecursively(ListNode head, ListNode listNode) {

        if(listNode.next == null) {
            head = listNode;
            return head;
        }

        head = reverseRecursively(head,listNode.next);
        ListNode temp = listNode.next;
        temp.next = listNode;
        // above two lines can be put as listNode.next.next = listNode;
        listNode.next = null;
        return head;

    }

    public static ListNode createList(List<Integer> list) {
        ListNode root = null;
        ListNode currentNode = null;
        for(int x : list) {

            if(root == null) {
                root = new ListNode(x);
                currentNode = root;
            } else {
                currentNode.next = new ListNode(x);
                currentNode = currentNode.next;

            }
        }

        return root;
    }

    public static void printList(ListNode listNode) {
        if(null == listNode) {
            System.out.println("list is empty");
        }

        while(listNode !=null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static void reversePrintList(ListNode listNode) {
        if(null == listNode) {
            System.out.println("list is empty");
            return;
        }

        reversePrintList(listNode.next);
        System.out.println(listNode.val);

    }

    public static ListNode intersectionPoint(ListNode l1,ListNode l2) {

        if(l1==null || l2==null) {
            return null;
        }

        HashSet<ListNode> nodes = new HashSet<>();
        while(l1!=null) {

            nodes.add(l1);
            l1=l1.next;
        }

        while(l2!=null) {
            if(nodes.contains(l2)) {
                return l2;
            }
            l2 = l2.next;
        }

      return null;
    }
}
