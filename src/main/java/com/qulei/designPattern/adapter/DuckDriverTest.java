package com.qulei.designPattern.adapter;

public class DuckDriverTest {

	public static void main(String[] args) {

		Turkey turkey = new WildTurkey();
		Duck duck = new TurkeyAdapter(turkey);

		duck.quack();
		duck.fly();

	}
}
