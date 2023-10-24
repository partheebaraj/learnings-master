package com.ds.arrays;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;

public class SingleNonDuplicateNumber {

    public static void main(String[] args) {
        System.out.println(singleNonDuplicateNumber(new int[]{5,5,4,6,6,7,8,8,7,1,2,2,1,4,9}));
    }

    public static int singleNonDuplicateNumber(int[] nums){

        int result=nums[0];
        int length = nums.length;
        for ( int i=1;i<length;i++)
        {
            result = result ^ nums[i];
        }
       return result;
    }

    public static int  singleNonDuplicateNumberUsingMap(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : nums){
            if(map.containsKey(x)) {
                map.put(x,map.get(x)+1);
            } else {
                map.put(x,1);
            }
        }

        for(int x: nums) {
            if(map.get(x)==1) {
                return x;
            }
        }

        return -1;
    }


}
