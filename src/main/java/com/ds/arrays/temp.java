package com.ds.arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/**
 * @author Partheebaraj.Sankarlal
 * @project learnings-master
 */
public class temp {
	public static void main(String[] args) {
		int[] arr = new int[] {4, 3, 1, 1, 2, 5};
		int target = 6;
		int[] answer = usingHashMap(arr, target);
		System.out.println("Answer" + Arrays.toString(answer));
		List<int[]> answer1 = usingHashMap2(arr, target);
		for (int[] pair : answer1) {
			System.out.println("Pair: " + Arrays.toString(pair));
		}
		int [] answer2 = usingInputArraySorted(arr, target);
		System.out.println("answer2" + Arrays.toString(answer2));
	}
	private static int[] usingInputArraySorted(int[] arr, int target) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for (int i=0; i<arr.length; i++) {
			int complment  = target - arr[i];
			if (map.containsKey(complment)) {
				return new int[] {map.get(complment)+1, ++i };
			} else {
				map.put(arr[i], i++);
			}

		}
		return new int[]{};
	}
	private static List<int[]> usingHashMap2(int[] arr, int target) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		List<int[]> output = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int complement = target - arr[i];
			if(map.containsKey(complement)){
				List<Integer> indices = map.get(complement);
				for (int index : indices){
					output.add(new int[]{index,i});
				}

			}  if (!map.containsKey(arr[i])) {
				map.put(arr[i], new ArrayList<>());
			}
			map.get(arr[i]).add(i);

		}
		return output;
	}
	private static int[] usingHashMap(int[] arr, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(target - arr[i])) {
				return new int[] {map.get((target - arr[i])), i};
			}
			else {
				map.put(arr[i], i);
			}
		}
		return new int[] {};
	}
	private static List<int[]> usingHashMap1(int[] arr, int target) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		List<int[]> result = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int complement = target - arr[i];
			if (map.containsKey(complement)) {
				List<Integer> indices = map.get(complement);
				for (int index : indices) {
					result.add(new int[] {index, i});
				}
			}
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], new ArrayList<>());
			}
			map.get(arr[i]).add(i);
		}
		return result;
	}
}
