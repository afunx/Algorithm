package com.afunx.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

	/**
	 * Bubble Sort(ascending order)
	 * 冒泡排序（升序排列）
	 *
	 * @param array
	 * 				array  waiting for sort
	 *            	待排序数组
	 */
	private static void bubbleSort(int[] array) {
		final int size = array.length;
		// i为每次冒泡排序的最大边界，每次循环过后，array[i]都是剩余元素中最大的
		for (int i = size - 1; i > 0; i--) {
			// j为每次冒泡排序进行比较的两个元素中，索引较大元素大索引位置
			for (int j = 1; j <= i; j++) {
				if (array[j - 1] > array[j]) {
					swap(array, j - 1, j);
				}
			}
		}
	}

	/**
	 * Swap two elements in the array.
	 * 交换数组中两个元素的位置。
	 *
	 * @param array
	 * 				array waiting for swap
	 * 				待交换数组
	 * @param i
	 * 				element position
	 * 				元素位置
	 * @param j
	 * 				element position
	 * 				元素位置
	 */
	private static void swap(int[] array, int i, int j) {
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
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}

}
