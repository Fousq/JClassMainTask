package kz.zhanbolat.jclass.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Rock {
	private String name;
	private BigInteger cost;
	private int weight;
	private BigDecimal transparency;
	private RockValueType value;
	
	public Rock(String name, BigInteger cost, int weight,
				BigDecimal transparency, RockValueType value) {
		this.name = name;
		this.cost = cost;
		this.weight = weight;
		this.transparency = transparency;
		this.value = value;
	}
	
	public Rock(String name, long cost, int weight, double transparency, 
				RockValueType value) {
		this.name = name;
		this.cost = BigInteger.valueOf(cost);
		this.weight = weight;
		this.transparency = BigDecimal.valueOf(transparency);
		this.value = value;
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
	
	public RockValueType getValue() {
		return value;
	}
	
	public void setValue(RockValueType value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Rock [name=" + name + ", cost=" + cost + ", weight=" + weight +
				", transparency=" + transparency + ", value=" + value + "]";
	}
	
}
