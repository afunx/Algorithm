package com.afunx.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	private static void qsort(int[] array, int p, int r) {
		if (p < r) {
			int q = partition(array, p, r);
			qsort(array, p, q);
			qsort(array, q + 1, r);
		}
	}

	private static int partition(int[] array, int p, int r) {
		int key = array[p];
		int k = p - 1;
		for (int i = p + 1; i <= r; i++) {
			if (key > array[i]) {
				++k;
				// swap array[i] and array[k]
				array[i] = array[i] ^ array[k];
				array[k] = array[i] ^ array[k];
				array[i] = array[i] ^ array[k];
			}
		}
		array[k + 1] = key;
		return k + 1;
	}

	public static void main(String args[]) {
		int[] array = new int[50];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(20);
		}
		qsort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

}
