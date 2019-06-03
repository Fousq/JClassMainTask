package kz.zhanbolat.jclass.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import kz.zhanbolat.jclass.entity.Stone;

public class SortStones {
	public static void sort(List<Stone> stones, Comparator<Stone> comparator) {
		Collections.sort(stones, comparator);
	}
}
