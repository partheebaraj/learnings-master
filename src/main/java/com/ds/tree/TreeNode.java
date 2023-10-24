package com.ds.tree;


import lombok.Data;

import java.util.*;

@Data
public class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left=this.right=null;
    }

    public static TreeNode levelOrderInsert(TreeNode root,int value) {

        if(root == null) {
            root = new TreeNode(value);
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
           TreeNode tempNode =  queue.peek();
           queue.remove();

           if(tempNode.left==null) {
               tempNode.left =new TreeNode(value);
               break;
           } else {
               queue.add(tempNode.left);
           }
            if(tempNode.right==null) {
                tempNode.right =new TreeNode(value);
                break;
            } else {
                queue.add(tempNode.right);
            }


        }
       return root;

    }

    public static int getMinimum(TreeNode root){

        int minimum = Integer.MAX_VALUE;
        if(root != null) {
            minimum = Math.min(minimum,root.data);
            minimum = Math.min(minimum,getMinimum(root.left));
            minimum = Math.min(minimum,getMinimum(root.right));
        }
        return minimum;
    }

    public static int getMaximum(TreeNode root){

        int maximum = Integer.MIN_VALUE;
        if(root != null) {
            maximum = Math.max(maximum,root.data);
            maximum = Math.max(maximum,getMaximum(root.left));
            maximum = Math.max(maximum,getMaximum(root.right));
        }
        return maximum;
    }

    public static void inOrderTraversal(TreeNode currentNode) {
        if(currentNode != null) {
            System.out.println(currentNode.data);
            inOrderTraversal(currentNode.left);
            inOrderTraversal(currentNode.right);

        }
    }

    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        LinkedList<List<Integer>> lists = new LinkedList<>();
        if(root == null) {
            return lists;
        }
        Queue<TreeNodeLevel> queue = new LinkedList<>();
        queue.add(new TreeNodeLevel(root,0));
        Map<Integer,LinkedList<Integer>> map = new HashMap<>();

        while(!queue.isEmpty()) {
            TreeNodeLevel nodeLevel = queue.poll();
            int level = nodeLevel.getLevel();
            if(map.containsKey(level)) {
                LinkedList<Integer> list = map.get(level);
                list.add(nodeLevel.getTreeNode().data);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(nodeLevel.getTreeNode().data);
                map.put(level,list);
            }
            if(nodeLevel.getTreeNode().left!=null) {
                queue.add(new TreeNodeLevel(nodeLevel.getTreeNode().left,nodeLevel.getLevel()+1));
            }
            if(nodeLevel.getTreeNode().right!=null) {
                queue.add(new TreeNodeLevel(nodeLevel.getTreeNode().right,nodeLevel.getLevel()+1));
            }
        }


        lists.addAll(map.values());
        System.out.println(lists);
        return lists;
    }



    public static void main(String[] args) {

        TreeNode root = TreeNode.levelOrderInsert(null,19);
        root = TreeNode.levelOrderInsert(root,6);
        root = TreeNode.levelOrderInsert(root,9);
        root = TreeNode.levelOrderInsert(root,41);
        root = TreeNode.levelOrderInsert(root,159);
        root = TreeNode.levelOrderInsert(root,159);
        root = TreeNode.levelOrderInsert(root,161);
        root = TreeNode.levelOrderInsert(root,2);

        root = TreeNode.levelOrderInsert(root,70);

        root = TreeNode.levelOrderInsert(root,82);

        //System.out.println(root.data);
       // TreeNode.inOrderTraversal(root);

        //System.out.println(TreeNode.getMinimum(root));
        //System.out.println(TreeNode.getMaximum(root));

       //levelOrderTraversal(root);
        System.out.println(HeightOfTree.getHeight(root));

    }

}

class TreeNodeLevel {
    TreeNode treeNode;
    int level;

    public TreeNodeLevel(TreeNode treeNode , int level) {
        this.treeNode = treeNode;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public TreeNode getTreeNode(){
        return treeNode;
    }
}
