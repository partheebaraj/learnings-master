package com.ds.tree;

import java.util.Scanner;

public class InsertBST {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        TreeNode root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        TreeNode.inOrderTraversal(root);
    }

    public static TreeNode insert(TreeNode root, int data) {

        if(root == null) {
            root = new TreeNode(data);
            return root;
        }

        TreeNode current;
        if(data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

}
