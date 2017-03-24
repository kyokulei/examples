package com.qulei.designPattern.iterator;

import java.util.Enumeration;
import java.util.Iterator;

public class IteratorAdapter<T> implements Iterator<T> {

	Enumeration<T> e;

	public IteratorAdapter(Enumeration<T> e) {
		this.e = e;
	}

	@Override
	public boolean hasNext() {
		return e.hasMoreElements();
	}

	@Override
	public T next() {
		return e.nextElement();
	}

}
