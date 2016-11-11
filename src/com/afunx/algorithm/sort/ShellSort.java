package com.afunx.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {

	private static int shellSort(int[] array) {
		int op = 0;
		int n = array.length;
		int h, i, j, key;
		for (h = n / 2; h > 0; h /= 2) {
			for (i = h; i < n; i++) {
				key = array[i];
				for (j = i - h; j >= 0 && array[j] > key; j -= h) {
					array[j + h] = array[j];
					++op;
				}
				array[j + h] = key;
				++op;
			}
		}
		return op;
	}

	public static void main(String args[]) {
		int[] array = new int[50];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(20);
		}
		shellSort(array);
		System.out.println(Arrays.toString(array));
	}
}
