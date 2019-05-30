package kz.zhanbolat.jclass.action.calculator;

import java.math.BigDecimal;
import java.util.List;

public class TotalCostCalculator implements Calculator {

	@Override
	public BigDecimal calculate(List<Number> numbers) {
		BigDecimal totalCost = BigDecimal.ZERO;
		for (Number number : numbers) {
			totalCost = totalCost.add(BigDecimal.valueOf(number.doubleValue()));
		}
		return totalCost;
	}

}
