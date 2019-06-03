package kz.zhanbolat.jclass;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kz.zhanbolat.jclass.entity.FeatureType;
import kz.zhanbolat.jclass.entity.Gem;
import kz.zhanbolat.jclass.entity.RarityType;
import kz.zhanbolat.jclass.entity.SemipreciousStone;
import kz.zhanbolat.jclass.entity.Stone;
import kz.zhanbolat.jclass.entity.StoneValuationType;
import kz.zhanbolat.jclass.exception.RangeException;
import kz.zhanbolat.jclass.exception.StoneException;
import kz.zhanbolat.jclass.exception.StoneTransparencyException;
import kz.zhanbolat.jclass.finder.StonesFinder;

public class StonesFinderTest {
	
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
	public void findTest() {
		List<Stone> found;
		try {
			StonesFinder.findByRangeOfTransperincy(stones, -1, 0.1);
		} catch (RangeException | StoneTransparencyException e) {
			logger.error(e.getMessage());
		}
		try {
			StonesFinder.findByRangeOfTransperincy(stones, 0, 3);
		} catch (RangeException | StoneTransparencyException e) {
			logger.error(e.getMessage());
		}
		try {
			StonesFinder.findByRangeOfTransperincy(stones, 1, 0.1);
		} catch (RangeException | StoneTransparencyException e) {
			logger.error(e.getMessage());
		}
		try {
			found = StonesFinder.findByRangeOfTransperincy(stones, 0.6, 0.8);
			logger.info(found);
		} catch (RangeException | StoneTransparencyException e) {
			logger.error(e.getMessage());
		}
	}
	
}
