package com.afunx.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class SelectSort {
	
	/**
	 * Select Sort(ascending order)
	 * 选择排序（升序排列）
	 *
	 * @param array
	 * 				array  waiting for sort
	 *            	待排序数组
	 */
	private static void selectSort(int[] array) {
		// min: min value in array, k: index of min value in array.
		// min: array数组中的最小值, k: 最小值在数组中的索引。
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
				swap(array, k, i);
			}
		}
	}

	private static void swap(int[] array, int j, int i) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String args[]) {
		int[] array = new int[50];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(20);
		}
		selectSort(array);
		System.out.println(Arrays.toString(array));
	}
}
