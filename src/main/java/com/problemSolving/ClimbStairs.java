package com.problemSolving;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

    private static Map<Integer,Integer> mapStorage = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(climbStairsUsingArrayStorage(5));
    }


    private static int climbStairs(int n) {
        if(n==1) {
            return 1;
        } else if(n==2) {
            return 2;
        }
        int nMinusTwo = mapStorage.containsKey(n-2)  ? mapStorage.get(n-2) : climbStairs(n-2);
        int nMinusOne = mapStorage.containsKey(n-1)  ? mapStorage.get(n-1) : climbStairs(n-1);
        int result = (nMinusTwo+nMinusOne);
        if(!mapStorage.containsKey(n)) {
            mapStorage.put(n, result);
        }
        return result;
    }

    private static int climbStairsUsingArrayStorage(int n) {
        int[] storage = new int[n];
        storage[0]=1;
        storage[1]=2;

        for(int i=2;i<n;i++) {
            storage[i] = storage[i-1]+storage[i-2];
        }
        return storage[n-1];
    }
}
