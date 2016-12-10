package com.afunx.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class RadixSort {
	public static void main(String args[]) {
		int[] array = new int[50];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(20);
		}
		radixSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void radixSort(int[] array) {
		final int radix = 10;
		int max = array[0];
		int length = array.length;
		// find max value
		for (int i = 1; i < length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		// find digits
		int d = 0;
		while (max != 0) {
			++d;
			max /= radix;
		}

		int[][] temp = new int[radix][length];
		int[] order = new int[radix];
		int n = 1;
		int k;
		for (int m = 0; m < d; m++) {
			for (int i = 0; i < array.length; i++) {
				int reminder = (array[i] / n) % radix;
				temp[reminder][order[reminder]++] = array[i];
			}
			k = 0;
			for (int i = 0; i < radix; i++) {
				if (order[i] != 0) {
					for (int j = 0; j < order[i]; j++) {
						array[k++] = temp[i][j];
					}
					order[i] = 0;
				}
			}
			n *= radix;
		}
	}
}
