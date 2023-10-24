package com.ds.arrays;

/**
 * @author Partheebaraj.Sankarlal
 * @project learnings-master
 */

import java.util.HashMap;

/**
 * You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.
 *
 * Return the sum of all the unique elements of nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,2]
 * Output: 4
 * Explanation: The unique elements are [1,3], and the sum is 4.
 */
public class SumofUniqueElements {

    public static void main(String args[]){
        SumofUniqueElements obj = new SumofUniqueElements();
        int[] nums = {1, 2, 3, 2,2};
        System.out.println(obj.sumOfUniqueElements(nums));

    }

    private int sumOfUniqueElements(int[] nums) {
//        int sum = 0;
//        HashMap <Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
////            sum += nums[i];
//            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//            System.out.println(map);
//            if(map.get(nums[i])==1){
//                sum+= nums[i];
//            }
//            if(map.get(nums[i]) == 2) {
//                sum-=nums[i];
//            }
//        }
//        return sum;


        int[] unique = new int[10];
        int ans = 0;
        for (int num: nums) {
            unique[num - 1]++;
            if (unique[num - 1] == 1) ans += num;
            else if (unique[num - 1] == 2) ans -= num;
        }
        return ans;

    }
}