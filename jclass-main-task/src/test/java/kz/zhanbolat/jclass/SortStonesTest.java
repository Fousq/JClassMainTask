package kz.zhanbolat.jclass;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kz.zhanbolat.jclass.entity.Stone;
import kz.zhanbolat.jclass.sort.SortStones;

public class SortStonesTest {
	
	List<Stone> stones;
	Logger logger = Logger.getLogger(getClass());
	
	@Before
	public void predata() {
		stones = new ArrayList<>();
	}
	
	@Test
	public void testSort() {
		SortStones.sort(stones, new Stone.CompareByValuation());
		logger.info(stones);
	}
	
}
