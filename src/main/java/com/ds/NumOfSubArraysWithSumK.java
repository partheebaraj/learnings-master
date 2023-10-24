package com.ds;

import java.util.HashMap;

public class NumOfSubArraysWithSumK {

    public static void main(String[] args) {

        int[] input = {10, 2, -2, -20, 10};

        System.out.println(numOfSubArraysWithSumK(input,-10));


    }

    private static int numOfSubArraysWithSumK(int[] input,int target) {

        int res =0;
        int currentSum=0;
        HashMap<Integer,Integer> previousSum = new HashMap<>();

        for(int i=0;i<input.length;i++) {

            currentSum+= input[i];
            if(currentSum==target) {
                res++;
            }

            if(previousSum.containsKey(currentSum-target)) {
                res+=previousSum.get(currentSum-target);
            }

            if(!previousSum.containsKey(currentSum)) {
                previousSum.put(currentSum,1);
            } else {
                previousSum.put(currentSum,1+previousSum.get(currentSum));
            }

        }

        return res;

    }


}
