package kz.zhanbolat.jclass.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

import kz.zhanbolat.jclass.exception.SemipreciousStoneException;
import kz.zhanbolat.jclass.exception.StoneException;

public class SemipreciousStone extends Stone {

	public SemipreciousStone(String name, BigInteger cost, int weight, BigDecimal transparency,
			StoneValuationType valuation, RarityType rarity) throws StoneException {
		super(name, cost, weight, transparency, valuation, rarity);
	}

	@Override
	public void setRarity(RarityType rarity) throws StoneException {
		if (rarity == RarityType.RARE) {
			throw new SemipreciousStoneException("Not a semiprecious stone, because of rarity of the stone.");
		}
		super.setRarity(rarity);
	}
	
	@Override
	public void setValuation(StoneValuationType valuation) 
											throws StoneException {
		if (valuation == StoneValuationType.HIGH) {
			throw new SemipreciousStoneException("Not a semiprecious stone, because of valuation of the stone.");
		}
		super.setValuation(valuation);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SemipreciousStone [toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
