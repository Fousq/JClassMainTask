package kz.zhanbolat.jclass.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
		return "Necklace [stones=" + stones + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stones == null) ? 0 : stones.hashCode());
		return result;
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
		if (stones == null) {
			if (other.stones != null)
				return false;
		} else if (!stones.equals(other.stones))
			return false;
		return true;
	}
	
}
