package com.ds.tree;

import java.util.ArrayList;

public class IsBST {

    private static TreeNode previousNode = null;
    public static void main(String[] args) {

        TreeNode root = TreeNode.levelOrderInsert(null,4);
        root = TreeNode.levelOrderInsert(root,2);
        root = TreeNode.levelOrderInsert(root,5);
        root = TreeNode.levelOrderInsert(root,1);
        root = TreeNode.levelOrderInsert(root,3);
        root = TreeNode.levelOrderInsert(root,6);
        root = TreeNode.levelOrderInsert(root,7);
        root = TreeNode.levelOrderInsert(root,8);

        System.out.println(TreeNode.getMinimum(root));
        System.out.println(TreeNode.getMaximum(root));

        //int minimum = TreeNode.getMinimum(root);
        //int maximum = TreeNode.getMinimum(root);

        //System.out.println(isBST(root,minimum,maximum));
        //System.out.println(isBST(root));

       // System.out.println(isBSTUsingPreviousNode(root));


        ZigZagTraversal.printZigZagTraversal(root);

    }

    public static  boolean isBST(TreeNode node,int minimum,int maximum) {
        if(null == node) {
            return true;
        }

        if((node.data < minimum) || (node.data >maximum)) {
            return false;
        }

        return isBST(node.left,minimum,maximum-1) && isBST(node.right,minimum+1,maximum);

    }

    public static  boolean isBST(TreeNode node) {
        if(null == node) {
            return true;
        }

        ArrayList<Integer> al = new ArrayList<>();

        getArrayAfterInOrderTraversal(al,node);

        System.out.println(al);

        for(int i=1;i<al.size();i++) {
            if(al.get(i-1)>al.get(i)) {
                return false;
            }
        }


        return true;

    }

    public static boolean isBSTUsingPreviousNode(TreeNode node) {
        if(null != node) {

            if(!isBSTUsingPreviousNode(node.left)) {
                return false;
            }

            if (previousNode != null && node.data <= previousNode.data) {
                return false;
            }
            previousNode = node;

            return isBSTUsingPreviousNode(node.right);
        }
      return true;
    }

    public static void getArrayAfterInOrderTraversal(ArrayList<Integer> al,TreeNode node) {

        if(node != null) {
            getArrayAfterInOrderTraversal(al,node.left);
            al.add(node.data);
            getArrayAfterInOrderTraversal(al,node.right);
        }
    }

}
