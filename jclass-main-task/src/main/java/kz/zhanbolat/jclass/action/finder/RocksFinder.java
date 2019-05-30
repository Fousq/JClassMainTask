package kz.zhanbolat.jclass.action.finder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import kz.zhanbolat.jclass.entity.Rock;
import kz.zhanbolat.jclass.exception.RangeException;

public class RocksFinder {
	
	public List<Rock> findByRangeOfTransperincy(List<Rock> rocks,
												BigDecimal start,
												BigDecimal end) throws RangeException{
		if (start.compareTo(end) > 0) {
			throw new RangeException();
		}
		List<Rock> found = rocks.stream().filter(rock -> 
														rock.getTransparency()
																.compareTo(start) >= 0 
													&& rock.getTransparency()
																.compareTo(end) <= 0)
																	.collect(Collectors.toList());
		return found;
	}
	
}
