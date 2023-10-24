package com.ds.tree;

public class IsSymmetric {

    public static void main(String[] args) {

        TreeNode root = TreeNode.levelOrderInsert(null,19);
        root = TreeNode.levelOrderInsert(root,6);
        root = TreeNode.levelOrderInsert(root,9);
        root = TreeNode.levelOrderInsert(root,41);
        root = TreeNode.levelOrderInsert(root,159);
        root = TreeNode.levelOrderInsert(root,161);
        root = TreeNode.levelOrderInsert(root,2);

        root = TreeNode.levelOrderInsert(root,70);

        root = TreeNode.levelOrderInsert(root,82);

        //System.out.println(root.data);
       TreeNode.inOrderTraversal(root);

        System.out.println(TreeNode.getMinimum(root));
        System.out.println(TreeNode.getMaximum(root));


    }

    public static boolean isSymmetric(TreeNode node) {

        return isMirror(node,node);
    }

    public static boolean isMirror(TreeNode node1,TreeNode node2){

        if(node1 == null && node2==null) {
            return true;
        }

        if(node1!=null & node2!=null && node1.data==node2.data) {
            return isMirror(node1.left,node2.right) && isMirror(node1.right,node2.left);
        }

        return false;

    }

}
