package com.afunx.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class CountSort {

	private static int[] countSort(int[] array) {
		int[] newArray = new int[array.length];
		int min = array[0];
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			} else if (array[i] < min) {
				min = array[i];
			}
		}
		// count range
		int k = max - min + 1;
		// count store
		int[] count = new int[k];
		for (int i = 0; i < array.length; i++) {
			count[array[i] - min] += 1;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] = count[i - 1] + count[i];
		}
		for (int i = array.length - 1; i >= 0; i--) {
			newArray[--count[array[i] - min]] = array[i];
		}
		return newArray;
	}

	public static void main(String args[]) {
		int[] array = new int[50];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(20);
		}
		array = countSort(array);
		System.out.println(Arrays.toString(array));
	}

}
