package com.afunx.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class InsertSort {

	private static int[] insertSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			while (j >= 0 && key < array[j]) {
				array[j + 1] = array[j];
				--j;
			}
			array[j + 1] = key;
		}
		return array;
	}

	public static void main(String args[]) {
		int[] array = new int[50];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(20);
		}
		array = insertSort(array);
		System.out.println(Arrays.toString(array));
	}

}
