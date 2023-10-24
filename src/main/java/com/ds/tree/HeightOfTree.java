package com.ds.tree;

public class HeightOfTree {

    public static void main(String[] args) {

        System.out.println();

    }

    public static int getHeight(TreeNode node) {

        if(node == null) {
            return 0;
        }

        return 1+Math.max(getHeight(node.left),getHeight(node.right));
    }
}
