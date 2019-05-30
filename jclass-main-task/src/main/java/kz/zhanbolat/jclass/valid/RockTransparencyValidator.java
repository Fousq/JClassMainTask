package kz.zhanbolat.jclass.valid;

import java.math.BigDecimal;

import kz.zhanbolat.jclass.entity.Rock;

public class RockTransparencyValidator implements RockValidator {

	private static final BigDecimal MIN_TRANSPARENCY = BigDecimal.ZERO;
	private static final BigDecimal MAX_TRANSPARENCY = BigDecimal.ONE;
	
	@Override
	public boolean isValid(Rock rock) { 
		return rock.getTransparency().compareTo(MAX_TRANSPARENCY) <= 0 && 
				rock.getTransparency().compareTo(MIN_TRANSPARENCY) >= 0;
	}

}
