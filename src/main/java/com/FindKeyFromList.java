package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindKeyFromList {
	public static void main(String[] args) {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("key1", "value1");
		map1.put("key2", "value2");
		list.add(map1);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("key3", "value3");
		map2.put("key4", "value4");
		list.add(map2);
		List<Object> result = list.stream()
				.map(x -> x.keySet())
				.flatMap(x -> x.stream().filter(key->"key2".equalsIgnoreCase(key)))
				.collect(Collectors.toList());
		System.out.println(result);
	}
}