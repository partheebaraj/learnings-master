package com.ds.tree;

public class DivideArrayMaximumHeightOfTreeIsMinimum {

    public static void main(String[] args) {
        System.out.println(divideArrayMaximumHeightOfTreeIsMinimum(new int[]{2,5,6,7,8,9,10}));
    }

    public static int divideArrayMaximumHeightOfTreeIsMinimum(int[] arr) {
        int len = arr.length;

         int level = getLog(len/2+len%2);

        return level-1;
    }

    private static int getLog(int n) {
        int level =0;
        while(n>0) {
            n=n/2;
            level++;
        }
        return level;
    }

}
