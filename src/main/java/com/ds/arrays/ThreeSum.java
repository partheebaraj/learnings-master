package com.ds.arrays;

import java.util.*;

/**
 *
 */
public class ThreeSum {


    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,1};
        int target = 9;
     //  List<List<Integer>> ans = threeSum(arr);
       int[] arrAns = twoSum(arr);


        System.out.println("Answer" + Arrays.toString(arrAns));


    }

    private static int[] twoSum(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<List<Integer>> set = new HashSet<>();
        int sum = 0;

        for (int i=0;i<arr.length-1;i++){
            if (map.containsKey(sum-arr[i])){
              set.add(Arrays.asList(map.get(sum-arr[i]), i));

                //return new int[]{map.get(sum-arr[i]),i};

            }else {
                map.put(arr[i],i);
            }

        }

        System.out.println("set" + set);
        return arr;
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> res = new HashSet<>();
        if (nums.length == 0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;

            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0) k--;
                else if (sum < 0) j++;
                System.out.println("End of while~");
            }

        }
        return new ArrayList<>(res);

    }
}






