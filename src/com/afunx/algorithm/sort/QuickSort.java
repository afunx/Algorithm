package com.afunx.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	private static void qsort(int[] array, int p, int r) {
		if (p < r) {
			int q = partition(array, p, r);
			qsort(array, p, q - 1);
			qsort(array, q + 1, r);
		}
	}

	private static void swap(int[] array, int i, int j) {
		if (i != j) {
			array[i] = array[i] ^ array[j];
			array[j] = array[i] ^ array[j];
			array[i] = array[i] ^ array[j];
		}
	}

	private static int partition(int[] array, int p, int r) {
		int key = array[r];
		int k = p - 1;
		for (int i = p; i < r; i++) {
			if (array[i] < key) {
				swap(array, ++k, i);
			}
		}
		swap(array, ++k, r);
		return k;
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
