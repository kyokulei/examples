package com.qulei.designPattern.composite;

public class TreeElement extends TreeComponent<String> {
	private String tag;
	private String value;

	public TreeElement(String tag, String value) {
		super();
		this.tag = tag;
		this.value = value;
	}

	@Override
	public String getTag() {
		return tag;
	}

	@Override
	public String getValue() {
		return value;
	}
}
