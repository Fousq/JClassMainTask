package kz.zhanbolat.jclass.validator;

import java.math.BigDecimal;

import kz.zhanbolat.jclass.entity.Stone;

public class StoneTransparencyValidator implements StoneValidator {

	private static final BigDecimal MIN_TRANSPARENCY = BigDecimal.ZERO;
	private static final BigDecimal MAX_TRANSPARENCY = BigDecimal.ONE;
	
	@Override
	public boolean valid(Stone rock) { 
		return rock.getTransparency().compareTo(MAX_TRANSPARENCY) <= 0 && 
				rock.getTransparency().compareTo(MIN_TRANSPARENCY) >= 0;
	}

}
