package kz.zhanbolat.jclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import kz.zhanbolat.jclass.calculator.TotalCostCalculator;
import kz.zhanbolat.jclass.calculator.TotalWeightCalculator;
import kz.zhanbolat.jclass.converter.CaratConverter;
import kz.zhanbolat.jclass.entity.FeatureType;
import kz.zhanbolat.jclass.entity.Gem;
import kz.zhanbolat.jclass.entity.Necklace;
import kz.zhanbolat.jclass.entity.RarityType;
import kz.zhanbolat.jclass.entity.SemipreciousStone;
import kz.zhanbolat.jclass.entity.Stone;
import kz.zhanbolat.jclass.entity.StoneValuationType;
import kz.zhanbolat.jclass.exception.RangeException;
import kz.zhanbolat.jclass.exception.StoneException;
import kz.zhanbolat.jclass.exception.StoneTransparencyException;
import kz.zhanbolat.jclass.finder.StonesFinder;
import kz.zhanbolat.jclass.sort.SortStones;

/**
 * Hello world!
 *
 */
public class App 
{
	static Logger logger = Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	Necklace necklace;
    	try {
    		necklace = new Necklace(new SemipreciousStone("Lopi", 150, 120, 0.6, 
					StoneValuationType.LOW, RarityType.FREQUENT),
    				new Gem("Brilliant", 1000, 10, 0.7, 
    						StoneValuationType.HIGH, RarityType.RARE,
    						FeatureType.SPECIAL_SHINING),
    				new SemipreciousStone("Log", 130, 100, 0.4, 
    						StoneValuationType.MIDDLE, RarityType.FREQUENT));
    	} catch (StoneException e) {
    		logger.error(e.getMessage());
    		logger.info("List of stones will be empty");
    		necklace = new Necklace();
    		try {
        		necklace.add(new Gem("Lapis", 100, 20, 0.6, StoneValuationType.HIGH,
    					RarityType.RARE, FeatureType.SPECIAL_SHINING));
        	} catch (StoneException e1) {
        		logger.error(e1.getMessage());
        	}
    	}
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	double start;
    	double end;
    	try {
    		logger.info("Enter the start: ");
    		start = Double.parseDouble(bf.readLine());
    		logger.info("Enter the end: ");
    		end = Double.parseDouble(bf.readLine());
    	} catch (IOException e) {
    		logger.error(e.getMessage());
    		logger.info("Variables start and end will be set to 0");
    		start = 0;
    		end = 0;
    	} finally {
    		try {
    			bf.close();
    		} catch (IOException e) {
    			logger.error(e.getMessage());
    		}
    	}
    	List<Stone> found;
    	try {
			found = StonesFinder.findByRangeOfTransperincy(necklace.getStones(), start, end);
		} catch (StoneTransparencyException | RangeException e) {
			logger.error(e.getMessage());
			logger.info("List of found stones will be empty");
			found = new ArrayList<>();
		}
    	logger.info("List of all stones:");
    	logger.info(necklace);
    	logger.info("List of found stones:");
    	logger.info(found);
    	logger.info("List of found stones and all stones will be sorted by valuation: ");
    	List<Stone> sorted = SortStones.sort(necklace.getStones(), new Stone.CompareByValuation());
    	logger.info("List of all stones:");
    	logger.info(sorted);
    	sorted = SortStones.sort(found, new Stone.CompareByValuation());
    	logger.info("List of found stones:");
    	logger.info(sorted);
    	BigDecimal total = TotalWeightCalculator.calculate(necklace.getStones(), new CaratConverter());
    	logger.info("Total weight: " + total);
    	total = TotalCostCalculator.calculate(necklace.getStones());
    	logger.info("Total cost: " + total);
    }
}
