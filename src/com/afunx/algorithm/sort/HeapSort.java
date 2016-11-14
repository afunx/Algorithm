package com.afunx.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {

	private static int getLeft(int i) {
		return 2 * i + 1;
	}

	private static int getRight(int i) {
		return 2 * i + 2;
	}
	
	private static void buildMax(int[] array) {
		for (int i = array.length / 2 - 1; i >= 0; i--) {
			heapifyMax(array, array.length, i);
		}
	}
	
	private static void heapifyMax(int[] array, int heapSize, int i) {
		int left = getLeft(i);
		int right = getRight(i);
		int max = i;
		if (left < heapSize && array[left] > array[max]) {
			max = left;
		}
		if (right < heapSize && array[right] > array[max]) {
			max = right;
		}
		if (max != i) {
			// swap array[i] and array[max]
			array[i] = array[i] ^ array[max];
			array[max] = array[i] ^ array[max];
			array[i] = array[i] ^ array[max];
			heapifyMax(array, heapSize, max);
		}
	}

	private static void heapSort(int[] array) {
		int last;
		buildMax(array);
		for (int i = 0; i < array.length - 1; i++) {
			last = array.length - 1 - i;
			// swap array[0] and array[last]
			array[0] = array[0] ^ array[last];
			array[last] = array[0] ^ array[last];
			array[0] = array[0] ^ array[last];
			heapifyMax(array, last, 0);
		}
	}

	public static void main(String args[]) {
		int[] array = new int[50];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(20);
		}
		heapSort(array);
		System.out.println(Arrays.toString(array));
	}

}
