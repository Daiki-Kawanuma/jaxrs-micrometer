package com.project.respite;

import java.util.Collections;
import java.util.List;

public class Foo {

	private String id;
	private List<Bar> bars = Collections.emptyList();

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Bar> getBars() {
		return bars;
	}
	public void setBars(List<Bar> bars) {
		this.bars = bars;
	}
}
