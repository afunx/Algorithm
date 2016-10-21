package com.afunx.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

	private static int[] bubbleSort(int[] array) {
		final int size = array.length;
		for (int i = 1; i < size; i++) {
			for (int j = 1; j < size; j++) {
				if (array[j - 1] > array[j]) {
					// swap
					array[j - 1] = array[j - 1] ^ array[j];
					array[j] = array[j - 1] ^ array[j];
					array[j - 1] = array[j - 1] ^ array[j];
				}
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
		array = bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}

}
