package kz.zhanbolat.jclass.finder;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import kz.zhanbolat.jclass.entity.Stone;
import kz.zhanbolat.jclass.exception.RangeException;

public class StonesFinder {
	
	public List<Stone> findByRangeOfTransperincy(List<Stone> stones,
												BigDecimal start,
												BigDecimal end) throws RangeException{
		if (start.compareTo(end) > 0) {
			throw new RangeException("Value of start must be less than value "
									+ "of end");
		} else if (start.compareTo(BigDecimal.ZERO) < 0 || 
					end.compareTo(BigDecimal.ZERO) < 0) {
			throw new RangeException("Value of start or end must not be "
									+ "negative");
		}
		List<Stone> found = stones.stream().filter(rock -> 
														rock.getTransparency()
																.compareTo(start) >= 0 
													&& rock.getTransparency()
																.compareTo(end) <= 0)
																	.collect(Collectors.toList());
		return found;
	}
	
}
