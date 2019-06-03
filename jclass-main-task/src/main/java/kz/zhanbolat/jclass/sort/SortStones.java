package kz.zhanbolat.jclass.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import kz.zhanbolat.jclass.entity.Stone;

public class SortStones {
	public static List<Stone> sort(List<Stone> stones, Comparator<Stone> comparator) {
		List<Stone> sorted = new ArrayList<>(stones);
		sorted.sort(comparator);
		return sorted;
	}
}
