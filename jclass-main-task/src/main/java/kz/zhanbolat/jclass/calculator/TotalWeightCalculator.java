package kz.zhanbolat.jclass.calculator;

import java.math.BigDecimal;
import java.util.List;

import kz.zhanbolat.jclass.converter.WeightConverter;
import kz.zhanbolat.jclass.entity.Stone;

public class TotalWeightCalculator {
	
	public static BigDecimal calculate(List<Stone> stones, 
								WeightConverter weightConverter) {
		BigDecimal totalWeight = BigDecimal.ZERO;
		for (Stone stone : stones) {
			totalWeight = totalWeight.add(BigDecimal.valueOf(stone.getWeight()));
		}
		return (weightConverter != null) ? weightConverter.convert(totalWeight) 
											: totalWeight;
	}
	
}
