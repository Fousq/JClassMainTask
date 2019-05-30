package kz.zhanbolat.jclass.converter;

import java.math.BigDecimal;

public class GramConverter implements WeightConverter {

	@Override
	public BigDecimal convert(BigDecimal weight) {
		return weight.multiply(GRAM_PER_CARAT);
	}

}
