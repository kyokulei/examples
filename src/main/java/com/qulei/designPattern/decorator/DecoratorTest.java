package com.qulei.designPattern.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecoratorTest {

	public static void main(String[] args) {

		int c;

		try (InputStream in = new LowCaseInputStream(
				new BufferedInputStream(new FileInputStream("hs_err_pid43782.log")))) {

			while ((c = in.read()) >= 0) {
				System.out.print((char) c);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		Person w = new ManWrapper(new Man());
		w.eat();
		w.sleep();
	}

}
