package kz.zhanbolat.jclass.action.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import kz.zhanbolat.jclass.entity.Rock;

public class SimpleSortRocks implements SortRocks {
	
	public List<Rock> sort(List<Rock> rocks) {
		List<Rock> sorted = new ArrayList<>(rocks);
		Collections.sort(sorted, new CompareByValue());
		return sorted;
	}
	
	public class CompareByValue implements Comparator<Rock> {
		
		@Override
		public int compare(Rock rock1, Rock rock2) {
			return rock1.getValue().compareTo(rock2.getValue());
		}
		
	}
	
}
