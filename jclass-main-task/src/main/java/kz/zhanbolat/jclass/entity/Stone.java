package kz.zhanbolat.jclass.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

import kz.zhanbolat.jclass.exception.StoneException;

public abstract class Stone {
	private String name;
	private BigInteger cost;
	private int weight;
	private BigDecimal transparency;
	private StoneValuationType valuation;
	private RarityType rarity;
	
	public Stone(String name, BigInteger cost, int weight,
				BigDecimal transparency, StoneValuationType valuation,
				RarityType rarity) throws StoneException {
		this.name = name;
		this.cost = cost;
		this.weight = weight;
		this.transparency = transparency;
		setValuation(valuation);
		setRarity(rarity);
	}
	
	public Stone(String name, long cost, int weight, double transparency, 
			StoneValuationType valuation, RarityType rarity) {
		this.name = name;
		this.cost = BigInteger.valueOf(cost);
		this.weight = weight;
		this.transparency = BigDecimal.valueOf(transparency);
		this.valuation = valuation;
		this.rarity = rarity;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getCost() {
		return cost;
	}

	public void setCost(BigInteger cost) {
		this.cost = cost;
	}

	public void setCost(long cost) {
		this.cost = BigInteger.valueOf(cost);
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public BigDecimal getTransparency() {
		return transparency;
	}

	public void setTransparency(BigDecimal transparency) {
		this.transparency = transparency;
	}
	
	public void setTransparency(double transparency) {
		this.transparency = BigDecimal.valueOf(transparency);
	}
	
	public StoneValuationType getValuation() {
		return valuation;
	}
	
	public void setValuation(StoneValuationType valuation) 
												throws StoneException {
		this.valuation = valuation;
	}
	
	public RarityType getRarity() {
		return rarity;
	}

	public void setRarity(RarityType rarity) throws StoneException {
		this.rarity = rarity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stone [name=");
		builder.append(name);
		builder.append(", cost=");
		builder.append(cost);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", transparency=");
		builder.append(transparency);
		builder.append(", valuation=");
		builder.append(valuation);
		builder.append(", rarity=");
		builder.append(rarity);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, name, rarity, transparency, valuation, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stone other = (Stone) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(name, other.name) && rarity == other.rarity
				&& Objects.equals(transparency, other.transparency) && valuation == other.valuation
				&& weight == other.weight;
	}
	
}
