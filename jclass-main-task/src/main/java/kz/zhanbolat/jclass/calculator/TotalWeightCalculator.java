package kz.zhanbolat.jclass.calculator;

import java.math.BigDecimal;
import java.util.List;

import kz.zhanbolat.jclass.converter.WeightConverter;

public class TotalWeightCalculator {
	
	public static BigDecimal calculate(List<Number> numbers, 
								WeightConverter weightConverter) {
		BigDecimal totalWeight = BigDecimal.ZERO;
		for (Number number : numbers) {
			totalWeight = totalWeight.add(BigDecimal.valueOf(number.doubleValue()));
		}
		return (weightConverter != null) ? weightConverter.convert(totalWeight) 
											: totalWeight;
	}
	
}
