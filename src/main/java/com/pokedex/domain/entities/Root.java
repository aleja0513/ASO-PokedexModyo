package com.pokedex.domain.entities;

import java.util.List;

public class Root {
	private String count;
	private List<Pokemon> list;
	
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public List<Pokemon> getList() {
		return list;
	}
	public void setList(List<Pokemon> list) {
		this.list = list;
	}
}
