package com.afunx.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

	private static void mergeSort(int[] array, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(array, p, q);
			mergeSort(array, q + 1, r);
			merge(array, p, q, r);
		}
	}

	private static void merge(int[] array, int p, int q, int r) {
		// array[p,p+1,...,q] array[q+1,q+2,...,r]
		// init array
		int size1 = q - p + 1;
		int size2 = r - q;
		int[] array1 = new int[size1];
		int[] array2 = new int[size2];
		for (int i = 0; i < array1.length; i++) {
			array1[i] = array[p + i];
		}
		for (int i = 0; i < array2.length; i++) {
			array2[i] = array[q + 1 + i];
		}
		// merge array
		int i = 0, j = 0, k = 0;
		while (i < size1 && j < size2) {
			if (array1[i] < array2[j]) {
				array[p + k++] = array1[i++];
			} else {
				array[p + k++] = array2[j++];
			}
		}
		while (i < size1) {
			array[p + k++] = array1[i++];
		}
		while (j < size2) {
			array[p + k++] = array2[j++];
		}
	}

	public static void main(String args[]) {
		int[] array = new int[50];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(20);
		}
		mergeSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

}
