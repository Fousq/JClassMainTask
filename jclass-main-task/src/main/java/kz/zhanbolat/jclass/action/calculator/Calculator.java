package kz.zhanbolat.jclass.action.calculator;

import java.math.BigDecimal;
import java.util.List;

public interface Calculator {
	public BigDecimal calculate(List<Number> numbers);
}
