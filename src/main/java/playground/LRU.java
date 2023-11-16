package playground;

import java.util.LinkedHashSet;

public class LRU {
	LinkedHashSet<Integer> set;
	static int faults;
	int maxSize;

	public LRU(int pageSize) {
		set = new LinkedHashSet<>();
		maxSize = pageSize;
	}
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 5, 3, 23, 4, 3, 1, 2, 3, 4};
		int pageSize = 1;
		LRU cache = new LRU(pageSize);
		for (int page : arr) {
			cache.refer(page);
		}
		System.out.println("cache: "+ cache.set);
		System.out.println("pagefault: "+ faults);
	}
	private void refer(int page) {
		if (set.contains(page)) {
			shuffle(page);
		} else {
			addnewPage(page);
		}
	}

	private void addnewPage(int page) {
		if(set.size()==maxSize){
			int firstPage = set.iterator().next();
			set.remove(firstPage);
			set.add(page);
		} else {
			set.add(page);
		}
		faults++;
	}

	private void shuffle(int page) {
		set.remove(page);
		set.add(page);
	}
}
