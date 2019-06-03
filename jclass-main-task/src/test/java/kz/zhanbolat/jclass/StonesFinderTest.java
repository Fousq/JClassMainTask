package kz.zhanbolat.jclass;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kz.zhanbolat.jclass.entity.Stone;
import kz.zhanbolat.jclass.exception.RangeException;
import kz.zhanbolat.jclass.exception.StoneTransparencyException;
import kz.zhanbolat.jclass.finder.StonesFinder;

public class StonesFinderTest {
	
	Logger logger = Logger.getLogger(getClass());
	List<Stone> stones;

	@Before
	public void predata() {
		stones = new ArrayList<>();
	}
	
	@Test
	public void findTest() {
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
	}
	
}
