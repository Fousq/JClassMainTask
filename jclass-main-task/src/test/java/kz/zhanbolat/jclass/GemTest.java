package kz.zhanbolat.jclass;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.apache.log4j.Logger;
import org.junit.Test;

import kz.zhanbolat.jclass.entity.FeatureType;
import kz.zhanbolat.jclass.entity.Gem;
import kz.zhanbolat.jclass.entity.RarityType;
import kz.zhanbolat.jclass.entity.StoneValuationType;
import kz.zhanbolat.jclass.exception.StoneException;

public class GemTest {
	
	Logger logger = Logger.getLogger(GemTest.class);
	
	@Test
	public void constructorTest() {
		Gem gem;
		try {
			gem = new Gem("Diamond", BigInteger.valueOf(100000), 100, 
					BigDecimal.valueOf(1), StoneValuationType.HIGH, RarityType.RARE,
					FeatureType.SPECIAL_SHINING);
			logger.info(gem);
		} catch (StoneException e) {
			logger.error(e.getMessage());
		}
		try {
			gem = new Gem("Topaz", 1000, 100, 0.9, StoneValuationType.HIGH,
					RarityType.RARE, FeatureType.COLOR_CHANGING);
			logger.info(gem);
		} catch (StoneException e) {
			logger.error(e.getMessage());
		}
		try {
			gem = new Gem("Ruby", 100000, 100, 0.7, StoneValuationType.MIDDLE,
					RarityType.RARE, FeatureType.SPECIAL_SHINING);
			logger.info(gem);
		} catch (StoneException e) {
			logger.error(e.getMessage());
		}
		try {
			gem = new Gem("Sapphire", 1000, 30, 0.2, StoneValuationType.LOW, 
					RarityType.RARE, FeatureType.SPECIAL_SHINING);
			logger.info(gem);
		} catch (StoneException e) {
			logger.error(e.getMessage());
		}
		try {
			gem = new Gem("Pearl", 100, 20, 0.7, StoneValuationType.HIGH,
					RarityType.FREQUENT, FeatureType.SPECIAL_SHINING);
			logger.info(gem);
		} catch (StoneException e) {
			logger.error(e.getMessage());
		}
		try {
			gem = new Gem("Lapis", 100, 20, -1, StoneValuationType.HIGH,
					RarityType.RARE, FeatureType.SPECIAL_SHINING);
			logger.info(gem);
		} catch (StoneException e) {
			logger.error(e.getMessage());
		}
		try {
			gem = new Gem("Lazuli", 300, 20, 1.2, StoneValuationType.HIGH,
					RarityType.RARE, FeatureType.SPECIAL_SHINING);
			logger.info(gem);
		} catch (StoneException e) {
			logger.error(e.getMessage());
		}
	}
	
}
