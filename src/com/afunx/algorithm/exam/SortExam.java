package com.afunx.algorithm.exam;

import java.util.Arrays;
import java.util.Random;

public class SortExam {
	
	private static final String[] items = new String[] { "HeapSort" };

	private static String getTestItem() {
		Random random = new Random();
		int itemKey = random.nextInt(items.length);
		return items[itemKey];
	}

	private static int[] getRandomArray() {
		int[] array = new int[50];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(20);
		}
		return array;
	}

	private static void sort(int[] array) {
		// TODO
	}

	public static void main(String args[]) {
		String testItem = getTestItem();
		System.out.println(testItem);

		int[] array = getRandomArray();
		System.out.println(Arrays.toString(array));
		sort(array);
		System.out.println(Arrays.toString(array));
	}
}
