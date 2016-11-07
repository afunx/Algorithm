package com.afunx.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class SelectSort {
	
	private static int[] selectSort(int[] array) {
		int min, k;
		for (int i = 0; i < array.length - 1; i++) {
			min = array[i];
			k = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < min) {
					k = j;
					min = array[j];
				}
			}
			// swap
			if (k != i) {
				array[k] = array[k] ^ array[i];
				array[i] = array[k] ^ array[i];
				array[k] = array[k] ^ array[i];
			}
		}
		return array;
	}
	
	public static void main(String args[]) {
		int[] array = new int[50];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(20);
		}
		array = selectSort(array);
		System.out.println(Arrays.toString(array));
	}
}
