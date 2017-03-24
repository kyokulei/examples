package com.qulei.designPattern.composite;

public abstract class TreeComponent<T> {

	public String getTag() {
		throw new UnsupportedOperationException();
	}

	public T getValue() {
		throw new UnsupportedOperationException();
	}

	public void add(TreeComponent<T> entry) {
		throw new UnsupportedOperationException();
	}

	public void remove(TreeComponent<T> entry) {
		throw new UnsupportedOperationException();
	}
}
