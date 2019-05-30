package kz.zhanbolat.jclass.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Necklace {
	
	private List<Rock> rocks;
	
	public Necklace(List<Rock> rocks) {
		this.rocks = rocks;
	}
	
	public Necklace(Rock... rocks) {
		this.rocks = Arrays.asList(rocks);
	}
	
	public Necklace() {
		rocks = new ArrayList<>();
	}
	
	public List<Rock> getRocks() {
		return Collections.unmodifiableList(rocks);
	}
	
	public void setRocks(List<Rock> rocks) {
		this.rocks = rocks;
	}
	
	public void setRocks(Rock... rocks) {
		this.rocks = Arrays.asList(rocks);
	}
	
	public Rock get(int index) {
		return rocks.get(index);
	}
	
	public void add(Rock rock) {
		rocks.add(rock);
	}
	
}
