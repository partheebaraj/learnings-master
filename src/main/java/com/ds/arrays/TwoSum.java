package com.ds.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwoSum {
    public static void main(String [] args) {
        int []arr = new int[]{7,8,4,3,5,1};
        int target = 6;

//       usingHashset(arr,target);
        int [] answer = usingHashMap(arr,target);
       System.out.print("Ans"+Arrays.toString(answer));

     TreeMap<String, String> tm2
                = new TreeMap<String, String>();

        // Inserting the elements in TreeMap
        // again using put() method
        tm2.put("a", "Geeks");
        tm2.put("c", "For");
        tm2.put("b", "Geeks");

        // Printing the elements of both TreeMaps

        // Map 1
        System.out.println(tm2);



    }

    private static int[] usingHashMap(int[] arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =0;i<arr.length;i++) {
            if (map.containsKey(target-arr[i])){
                return new int[] {map.get((target-arr[i])),i};
            }else {
                map.put(arr[i],i);
            }
        }
        return new int[]{};
    }

    private static void usingHashset(int[] arr, int target) {
        HashSet <Integer> set = new HashSet<>();
        int [] ans = new int[2];

        for (int i=0;i< arr.length;i++){
            if (set.contains(target-arr[i])) {
                ans[1]=i;
                break;
            }
            set.add(arr[i]);
        }
        for (int i=0;i<arr.length;i++){
            if ((arr[i]==target-arr[ans[1]]) && i!=ans[1]) {
                ans[0]=i;
            }
        }
        System.out.println("Ans" + ans );
    }
}
