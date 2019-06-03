package kz.zhanbolat.jclass;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import kz.zhanbolat.jclass.calculator.TotalWeightCalculator;
import kz.zhanbolat.jclass.converter.CaratConverter;
import kz.zhanbolat.jclass.converter.GramConverter;
import kz.zhanbolat.jclass.converter.WeightConverter;

public class TotalWeightCalculatorTest {
	Logger logger = Logger.getLogger(getClass());
	
	@Test
	public void calculatorTest() {
		List<Number> numbers = new ArrayList<>();
		numbers.add(BigInteger.valueOf(1000000));
		numbers.add(BigDecimal.valueOf(0.000002));
		numbers.add(Integer.valueOf(1090));
		numbers.add(Double.valueOf(0.043));
		WeightConverter weightConverter = new GramConverter();
		BigDecimal totalWeight = TotalWeightCalculator.calculate(numbers,
														weightConverter);
		logger.info("Total weight in gram: " + totalWeight);
		weightConverter = new CaratConverter();
		totalWeight = TotalWeightCalculator.calculate(numbers, weightConverter);
		logger.info("Total weight in carat: " + totalWeight);
		totalWeight = TotalWeightCalculator.calculate(numbers, null);
		logger.info("Total weight without converting: " + totalWeight);
	}
	
}
