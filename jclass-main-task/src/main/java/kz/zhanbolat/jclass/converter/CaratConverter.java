package kz.zhanbolat.jclass.converter;

import java.math.BigDecimal;

public class CaratConverter implements WeightConverter {

	@Override
	public BigDecimal convert(BigDecimal weight) {
		return weight.divide(GRAM_PER_CARAT);
	}
	
}
