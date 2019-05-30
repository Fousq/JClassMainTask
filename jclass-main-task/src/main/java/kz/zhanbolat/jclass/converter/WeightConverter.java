package kz.zhanbolat.jclass.converter;

import java.math.BigDecimal;

public interface WeightConverter {
	final BigDecimal GRAM_PER_CARAT = new BigDecimal(0.2); 
	BigDecimal convert(BigDecimal weight);
}
