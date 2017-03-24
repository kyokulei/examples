package com.qulei.designPattern.iterator;

import java.util.Enumeration;
import java.util.Vector;

public class Test {

	public static void main(String[] args) {

		Vector<String> v = new Vector<String>();
		v.addElement("aaaa");
		v.addElement("bbbb");
		v.addElement("cccc");

		Enumeration<String> e = v.elements();
		IteratorAdapter<String> ia = new IteratorAdapter<String>(e);
		while (ia.hasNext()) {
			System.out.println(ia.next());
		}

	}

}
