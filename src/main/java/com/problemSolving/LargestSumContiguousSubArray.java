package com.problemSolving;

import java.util.Arrays;

public class LargestSumContiguousSubArray {

    public static void main(String[] args) {
        System.out.println(largestSumContiguousSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(largestSumContiguousSubArray(new int[]{-2,-3,4,-1,-2,1,5,-3}));

    }

    public static int largestSumContiguousSubArrayUsingCadence(int[] nums) {
     int maxContiguousSubArraySum=0;
     int currentSubArraySum=0;


     for(int num : nums) {
         currentSubArraySum = currentSubArraySum + num;
         if(currentSubArraySum < 0) {
             currentSubArraySum = 0;
         }
         if(maxContiguousSubArraySum < currentSubArraySum) {
             maxContiguousSubArraySum = currentSubArraySum;
         }
     }
      return maxContiguousSubArraySum;
    }

    public static int largestSumContiguousSubArray(int[] nums) {
        int maxContiguousSubArraySum=nums[0];
        int currentSubArraySum=nums[0];


        for(int i=1;i<nums.length;i++) {
             currentSubArraySum = Math.max(currentSubArraySum + nums[i],nums[i]);
           // currentSubArraySum = Math.max(max,currentSubArraySum);
            if(maxContiguousSubArraySum < currentSubArraySum) {
                maxContiguousSubArraySum = currentSubArraySum;
            }
        }
        return maxContiguousSubArraySum;
    }
}
