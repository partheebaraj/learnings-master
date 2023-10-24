package com;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class SortMapByValue {

    public static void main(String[] args) {
        /*HashMap<Integer, Integer> map = new HashMap<>();
        map.put(5,2);
        map.put(7,3);
        map.put(9,7);
        map.put(8,1);
        map.put(6,24);
        map.put(1,5);

        ArrayList<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);

        LinkedHashMap<Integer,Integer> sortedMap = new LinkedHashMap<>();


        Set<Map.Entry<Integer,Integer>> entrySet = map.entrySet();
        LinkedList<Map.Entry<Integer,Integer>> list = new LinkedList<>(entrySet);
        *//*entrySet = entrySet.stream()
                .sorted((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                .map()
                .collect(Collectors.toSet());*//*
       // Collections.sort(list,(o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        //list.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        list.sort((o1, o2) -> o1.getKey().compareTo(o2.getKey()));


        map.entrySet()
           .stream()
           .sorted((o1,o2)->o2.getValue().compareTo(o1.getValue()))
                    .limit(1)
                .findFirst().get().getKey();*/

       /* map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x->sortedMap.put(x.getKey(),x.getValue()));
        System.out.println(sortedMap);*/

       /* sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(k,v)->k,LinkedHashMap::new));
        System.out.println(sortedMap);*/
       // System.out.println(list);

        majaorityElementOption2(new int[]{3, 3, 4, 2, 4, 4, 2, 4, 4});
    }

    public int majorityElement(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int num : nums) {
            if(map.containsKey(num)) {
                map.put(num,map.get(num)+1);
            } else {
                map.put(num,1);
            }
        }

        return map.entrySet()
                .stream()
                .sorted((o1,o2)->o2.getValue().compareTo(o1.getValue()))
                .limit(1)
                .findFirst().get().getKey();

    }

    public static void majaorityElementOption2(int[] nums){

        int length = nums.length;

        int index =-1;
        int maxCount = 0;
        for(int i=0;i<length;i++) {
            int count =0;

            for(int j=0;j<length;j++) {
                if(nums[i]==nums[j]) {
                    count++;
                }
            }
            if(count > maxCount) {
                maxCount = count;
                index = i;
            }

        }

        if(maxCount>length/2) {
            System.out.println(nums[index]);
        }else {
            System.out.println("majority element does not exit");
        }


    }
}
