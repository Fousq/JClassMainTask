package kz.zhanbolat.jclass.finder;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import kz.zhanbolat.jclass.entity.Stone;
import kz.zhanbolat.jclass.exception.RangeException;
import kz.zhanbolat.jclass.exception.StoneTransparencyException;
import kz.zhanbolat.jclass.validator.StoneTransparencyValidator;

public class StonesFinder {
	private static List<Stone> found;
	
	public static List<Stone> findByRangeOfTransperincy(List<Stone> stones,
												BigDecimal start, BigDecimal end)
												throws RangeException, 
												StoneTransparencyException {
		if (start.compareTo(end) > 0) {
			throw new RangeException("Value of start must be less than value "
									+ "of end");
		} else if (start.compareTo(BigDecimal.ZERO) < 0 || 
					end.compareTo(BigDecimal.ZERO) < 0) {
			throw new RangeException("Value of start or end must not be "
									+ "negative");
		} else if (!StoneTransparencyValidator.validTransparency(end) ||
				!StoneTransparencyValidator.validTransparency(start)) {
			throw new StoneTransparencyException("Value of start or end is not "
											+ "a transparency of the stone");
		}
		found = stones.stream().filter(stone -> 
							stone.getTransparency()
								.compareTo(start) >= 0 
							&& stone.getTransparency()
								.compareTo(end) <= 0)
							.collect(Collectors.toList());
		return found;
	}
	
	public static List<Stone> findByRangeOfTransperincy(List<Stone> stones,
			double start, double end) throws RangeException,
											 StoneTransparencyException {
		BigDecimal comparableStart = BigDecimal.valueOf(start);
		BigDecimal comparableEnd = BigDecimal.valueOf(end);
		if (comparableStart.compareTo(comparableEnd) > 0) {
			throw new RangeException("Value of start must be less than value "
					+ "of end");
		} else if (comparableStart.compareTo(BigDecimal.ZERO) < 0 || 
				comparableEnd.compareTo(BigDecimal.ZERO) < 0) {
			throw new RangeException("Value of start or end must not be "
					+ "negative");
		} else if (!StoneTransparencyValidator.validTransparency(end) ||
					!StoneTransparencyValidator.validTransparency(start)) {
			throw new StoneTransparencyException("Value of start or end is not "
												+ "a transparency of the stone");
		}
		found = stones.stream().filter(stone -> 
								stone.getTransparency()
									.compareTo(comparableStart) >= 0 
								&& stone.getTransparency()
									.compareTo(comparableEnd) <= 0)
										.collect(Collectors.toList());
		return found;
	}
	
}
