package com.ds.stack;

import java.util.LinkedList;

public class MinStack {

    static LinkedList<Node> linkedList;
    static int minimum;


    public static void main(String[] args) {

        /*linkedList.addFirst(-2);
        linkedList.addFirst(0);
        linkedList.addFirst(-3);

        System.out.println(linkedList);
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList);*/
        try {
            MinStack minStack = new MinStack();
            minStack.push(-10);
            minStack.push(14);
            System.out.println("current stack :"+linkedList);
            System.out.println("minStack.getMin()"+minStack.getMin());
            System.out.println("minStack.getMin()"+minStack.getMin());
            System.out.println("push -20 on stack");
            minStack.push(-20);
            System.out.println("current stack :"+linkedList);
            System.out.println("minStack.getMin()"+minStack.getMin());
            System.out.println("minStack.getMin()"+minStack.getMin());
            System.out.println("minStack.top()"+minStack.top());
            System.out.println("minStack.getMin()"+minStack.getMin());
            minStack.pop();
            System.out.println("current stack :"+linkedList);
            System.out.println("push 10 on stack");
            minStack.push(10);
            System.out.println("current stack :"+linkedList);
            System.out.println("push -7 on stack");
            minStack.push(-7);
            System.out.println("current stack :"+linkedList);


        } catch (RuntimeException ex) {
            System.out.println("error");
        }

        /*minStack.pop();
        System.out.println(linkedList);
        System.out.println(minStack.top());
        System.out.println(linkedList);
        System.out.println(minStack.getMin());
        System.out.println(linkedList);
        minStack.push(-15);
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(linkedList);*/

    }

    public MinStack() {
        linkedList = new LinkedList<>();
        minimum = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(linkedList.isEmpty()) {
            linkedList.addFirst(new Node(x,x));
        } else {
            linkedList.addFirst(new Node(x,Math.min(getMin(),x)));
        }
    }

    public void pop() {
        if(!linkedList.isEmpty()) {
            linkedList.remove(0);
        }

    }

    public int top() {
        if(!linkedList.isEmpty()) {
            return linkedList.getFirst().getVal();
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public int getMin() {
        if(!linkedList.isEmpty()) {
            return linkedList.getFirst().getMinimum();
        } else {
            return Integer.MAX_VALUE;
        }
    }


}

class Node {
    private int val;
    private int minimum;

    public Node(int val,int minimum) {
        this.val = val;
        this.minimum = minimum;
    }

    public int getMinimum() {
        return minimum;
    }

    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return String.valueOf("["+this.val+","+this.minimum+"]");
    }
}


