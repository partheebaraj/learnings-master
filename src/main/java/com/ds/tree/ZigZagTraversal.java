package com.ds.tree;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {


    public static void main(String[] args) {
        TreeNode root = TreeNode.levelOrderInsert(null,4);
        root = TreeNode.levelOrderInsert(root,2);
        root = TreeNode.levelOrderInsert(root,5);
        root = TreeNode.levelOrderInsert(root,1);
        root = TreeNode.levelOrderInsert(root,3);
        root = TreeNode.levelOrderInsert(root,6);
        root = TreeNode.levelOrderInsert(root,7);
        root = TreeNode.levelOrderInsert(root,8);
        root = TreeNode.levelOrderInsert(root,14);

        printZigZagTraversal(root);
    }


    public static void printZigZagTraversal(TreeNode node) {

        if(node == null) {
            return;
        }else if(node.left == null && node.right==null) {
            System.out.println(node.data);
            return;
        }

        Queue<MTreeNode> queue = new LinkedList<>();
        queue.add(new MTreeNode(node,0));
        HashMap<Integer,LinkedList<Integer>> map = new HashMap<>();

        while (!queue.isEmpty()){
            MTreeNode mNode = queue.poll();
            int level = mNode.getLevel();
            if(map.containsKey(level)) {
                LinkedList<Integer> list = map.get(level);
                list.add(mNode.getTreeNode().data);
            } else  {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(mNode.getTreeNode().data);
                map.put(level,list);
            }

            if(mNode.getTreeNode().left!=null) {
                queue.add(new MTreeNode(mNode.getTreeNode().left,level+1));
            }
            if(mNode.getTreeNode().right!=null) {
                queue.add(new MTreeNode(mNode.getTreeNode().right,level+1));
            }

        }

        for(int level : map.keySet()) {

            if(level%2==0) {
                System.out.println(map.get(level));
            } else {
                printReverse(map.get(level));
            }

        }

    }

    public static void  printReverse(LinkedList<Integer> list ) {

        int len = list.size();

        for(int i=len-1;i>=0;i--) {
            System.out.print(list.get(i));
            if(i!=0) {
                System.out.print(",");
            }
        }
        System.out.println();

    }

}

@RequiredArgsConstructor
@Data
class MTreeNode {
    private final TreeNode treeNode;
    private final int level;
}
