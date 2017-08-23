package com.afunx.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class BucketSort {

	public static void main(String args[]) {
		int[] array = new int[50];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(20);
		}
		bucketSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void bucketSort(int[] array) {
		final int bucketSize = 10;
		int[][] bucket = new int[bucketSize][array.length];
		int[] count = new int[bucketSize];
		// find max value
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		// calculate step
		// e.g. bucketSize = 10, max = 91, step = 10
		// e.g. bucketSize = 10, max = 90, step = 10
		// e.g. bucketSize = 10, max = 89, step = 9
		int step = max / bucketSize + 1;
		for (int i = 0; i < array.length; i++) {
			int key = array[i] / step;
			bucket[key][count[key]++] = array[i];
		}

		// sort each bucket
		for (int i = 0; i < bucket.length; i++) {
			sort(bucket[i], count[i]);
		}

		// merge
		int k = 0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				array[k++] = bucket[i][j];
			}
		}
	}

	private static void sort(int[] array, int length) {
		// maybe quick sort is better, but the main purpose is for BucketSort.
		// bubble sort is easy to write and read
		for (int i = length - 1; i > 0; i--) {
			for (int j = 1; j <= i; j++) {
				if (array[j] < array[j - 1]) {
					swap(array, j, j - 1);
				}
			}
		}
	}

	private static void swap(int[] array, int j, int i) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
