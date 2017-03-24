package com.qulei.algorithm;

public class Sort {

	public static void main(String[] args) {
		int a[] = { 6, 2, 4, 5, 1, 9, 10, 7 };
		bubbleSort(a);
		for (int i : a) {
			System.out.print(i + ",");
		}
		System.out.println("\r\n---------------");

		int b[] = { 6, 2, 4, 5, 1, 9, 10, 7 };
		selectSort2(b);
		for (int i : b) {
			System.out.print(i + ",");

		}
		System.out.println("\r\n---------------");

		int c[] = { 6, 2, 4, 5, 1, 9, 10, 7 };
		selectSort2(c);
		for (int i : c) {
			System.out.print(i + ",");
		}
		System.out.println("\r\n---------------");

		int d[] = { 6, 2, 4, 5, 1, 9, 10, 7 };
		insertSort(d);
		for (int i : d) {
			System.out.print(i + ",");
		}
		System.out.println("\r\n---------------");

	}

	public static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
		}
	}

	public static void selectSort1(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < a.length; j++) {
				if (a[minIndex] > a[j]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(a, i, minIndex);
			}
		}
	}

	public static void selectSort2(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					swap(a, i, j);
				}
			}
		}
	}

	public static void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int extractNum = a[i];
			int j = i - 1;

			while (j >= 0 && a[j] > extractNum) {
				a[j + 1] = a[j];
				j--;
			}

			a[j + 1] = extractNum;
		}
	}

	public static void swap(int[] a, int sourceIndex, int targetIndex) {

		int tValue = a[sourceIndex];
		a[sourceIndex] = a[targetIndex];
		a[targetIndex] = tValue;
	}

}
