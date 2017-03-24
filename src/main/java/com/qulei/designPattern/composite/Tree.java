package com.qulei.designPattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Tree extends TreeComponent<String> {

	private List<TreeComponent<String>> treeComponents = new ArrayList<TreeComponent<String>>();
	private String tag;

	public Tree(String tag) {
		this.tag = tag;
	}

	@Override
	public void add(TreeComponent<String> treeComponent) {
		treeComponents.add(treeComponent);
	}

	@Override
	public void remove(TreeComponent<String> treeComponent) {
		treeComponents.remove(treeComponent);
	}

	@Override
	public String getTag() {
		return this.tag;
	}

}
