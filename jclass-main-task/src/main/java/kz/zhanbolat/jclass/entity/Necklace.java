package kz.zhanbolat.jclass.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Necklace {
	
	private List<Stone> stones;
	
	public Necklace(List<Stone> stones) {
		this.stones = stones;
	}
	
	public Necklace(Stone... stones) {
		this.stones = Arrays.asList(stones);
	}
	
	public Necklace() {
		stones = new ArrayList<>();
	}
	
	public List<Stone> getStones() {
		return Collections.unmodifiableList(stones);
	}
	
	public void setStones(List<Stone> stones) {
		this.stones = stones;
	}
	
	public void setStones(Stone... stones) {
		this.stones = Arrays.asList(stones);
	}
	
	public Stone get(int index) {
		return stones.get(index);
	}
	
	public void add(Stone stone) {
		stones.add(stone);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Necklace [stones=");
		builder.append(stones);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(stones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Necklace other = (Necklace) obj;
		return Objects.equals(stones, other.stones);
	}
	
}
