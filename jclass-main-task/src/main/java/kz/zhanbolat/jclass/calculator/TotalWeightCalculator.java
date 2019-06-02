package kz.zhanbolat.jclass.calculator;

import java.math.BigDecimal;
import java.util.List;

public class TotalWeightCalculator implements Calculator {
	
	public BigDecimal calculate(List<Number> numbers) {
		BigDecimal totalWeight = BigDecimal.ZERO;
		for (Number number : numbers) {
			totalWeight = totalWeight.add(BigDecimal.valueOf(number.doubleValue()));
		}
		return totalWeight;
	}
	
}
