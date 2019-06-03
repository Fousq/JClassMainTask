package kz.zhanbolat.jclass.validator;

import java.math.BigDecimal;

import kz.zhanbolat.jclass.entity.Stone;

public class StoneTransparencyValidator {
	
	private static final BigDecimal MIN_TRANSPARENCY = BigDecimal.ZERO;
	private static final BigDecimal MAX_TRANSPARENCY = BigDecimal.ONE;
	
	public static boolean validTransparency(BigDecimal transparency) { 
		return transparency.compareTo(MAX_TRANSPARENCY) <= 0 && 
				transparency.compareTo(MIN_TRANSPARENCY) >= 0;
	}

	public static boolean validTransparency(double transparency) {
		BigDecimal comparableTransparency = BigDecimal.valueOf(transparency);
		return comparableTransparency.compareTo(MAX_TRANSPARENCY) <= 0 && 
				comparableTransparency.compareTo(MIN_TRANSPARENCY) >= 0;
	}
	
}
