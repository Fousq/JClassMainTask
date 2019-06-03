package kz.zhanbolat.jclass.calculator;

import java.math.BigDecimal;
import java.util.List;

import kz.zhanbolat.jclass.entity.Stone;

public class TotalCostCalculator {

	public static BigDecimal calculate(List<Stone> stones) {
		BigDecimal totalCost = BigDecimal.ZERO;
		for (Stone stone : stones) {
			totalCost = totalCost.add(BigDecimal.valueOf(stone.getCost().intValue()));
		}
		return totalCost;
	}

}
