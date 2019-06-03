package kz.zhanbolat.jclass;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kz.zhanbolat.jclass.entity.FeatureType;
import kz.zhanbolat.jclass.entity.Gem;
import kz.zhanbolat.jclass.entity.Necklace;
import kz.zhanbolat.jclass.entity.RarityType;
import kz.zhanbolat.jclass.entity.SemipreciousStone;
import kz.zhanbolat.jclass.entity.Stone;
import kz.zhanbolat.jclass.entity.StoneValuationType;
import kz.zhanbolat.jclass.exception.StoneException;

public class NecklaceTest {
	
	List<Stone> stones;
	Logger logger = Logger.getLogger(getClass());
	
	@Before
	public void predata() {
		stones = new ArrayList<>();
		try {
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
	public void constructorTest() {
		Necklace necklace = new Necklace();
		logger.info("quantity of stones: " + necklace.getStones().size());
		logger.info(necklace);
		try {
			necklace.add(new Gem("Brilliant", 1000, 10, 0.7, StoneValuationType.HIGH,
					RarityType.RARE, FeatureType.SPECIAL_SHINING));
		} catch(StoneException e) {
			logger.error(e.getMessage());
		}
		logger.info("quantity of stones: " + necklace.getStones().size());
		logger.info(necklace);
		necklace = new Necklace(stones);
		logger.info("quantity of stones: " + necklace.getStones().size());
		logger.info(necklace);
	}
	
}
