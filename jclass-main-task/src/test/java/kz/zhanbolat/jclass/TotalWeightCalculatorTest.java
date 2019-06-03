package kz.zhanbolat.jclass;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kz.zhanbolat.jclass.calculator.TotalWeightCalculator;
import kz.zhanbolat.jclass.converter.CaratConverter;
import kz.zhanbolat.jclass.converter.GramConverter;
import kz.zhanbolat.jclass.converter.WeightConverter;
import kz.zhanbolat.jclass.entity.FeatureType;
import kz.zhanbolat.jclass.entity.Gem;
import kz.zhanbolat.jclass.entity.RarityType;
import kz.zhanbolat.jclass.entity.SemipreciousStone;
import kz.zhanbolat.jclass.entity.Stone;
import kz.zhanbolat.jclass.entity.StoneValuationType;
import kz.zhanbolat.jclass.exception.StoneException;

public class TotalWeightCalculatorTest {
	List<Stone> stones;
	Logger logger = Logger.getLogger(getClass());
	
	@Before
	public void predata() {
		stones = new ArrayList<>();
		try {
			stones.add(new SemipreciousStone("Lopi", 150, 120, 0.6, 
					StoneValuationType.LOW, RarityType.FREQUENT));
			stones.add(new Gem("Brilliant", 1000, 10, 0.7, 
					StoneValuationType.HIGH, RarityType.RARE,
					FeatureType.SPECIAL_SHINING));
			stones.add(new SemipreciousStone("Log", 130, 100, 0.4, 
					StoneValuationType.MIDDLE, RarityType.FREQUENT));
		} catch(StoneException e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test
	public void calculatorTest() {
		WeightConverter weightConverter = new GramConverter();
		BigDecimal totalWeight = TotalWeightCalculator.calculate(stones,
														weightConverter);
		logger.info("Total weight in gram: " + totalWeight);
		weightConverter = new CaratConverter();
		totalWeight = TotalWeightCalculator.calculate(stones, weightConverter);
		logger.info("Total weight in carat: " + totalWeight);
		totalWeight = TotalWeightCalculator.calculate(stones, null);
		logger.info("Total weight without converting: " + totalWeight);
	}
	
}
