package kz.zhanbolat.jclass.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

import kz.zhanbolat.jclass.exception.GemException;
import kz.zhanbolat.jclass.exception.StoneException;

public class Gem extends Stone {
	private FeatureType feature;
	
	public Gem(String name, BigInteger cost, int weight, BigDecimal transparency, StoneValuationType valuation,
			RarityType rarity, FeatureType feature) throws StoneException {
		super(name, cost, weight, transparency, valuation, rarity);
		this.feature = feature;
	}

	@Override
	public void setRarity(RarityType rarity) throws StoneException {
		if (rarity != RarityType.RARE) {
			throw new GemException("Not a gem, because of rarity of the stone.");
		}
		super.setRarity(rarity);
	}
	
	@Override
	public void setValuation(StoneValuationType valuation) 
											throws StoneException {
		if (valuation != StoneValuationType.HIGH) {
			throw new GemException("Not a gem, because of valuation of the stone.");
		}
		super.setValuation(valuation);
	}

	public FeatureType getFeature() {
		return feature;
	}

	public void setFeature(FeatureType feature) {
		this.feature = feature;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Gem [feature=");
		builder.append(feature);
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(feature);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gem other = (Gem) obj;
		return feature == other.feature;
	}
	
}
