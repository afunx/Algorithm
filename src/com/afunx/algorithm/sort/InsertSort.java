package com.afunx.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class InsertSort {
	
	/**
	 * Insert Sort(ascending order)
	 * 插入排序（升序排列）
	 * 
	 * Initialize: When only one element, the array satisfies ascending order.
	 * 初始化：当只有一个数据时，数组是符合升序的。 
	 * Keep: The array is ascending order before new element is inserted.
	 *       The new inserted element is compared to elements in array and find its position.
	 * 保持：每次插入新数据之前，数组是符合升序的。新插入数据不断与升序数组中的元素比较，直到找到它的位置。
	 * Terminate: According to Initialize and Keep, it is easy to infer the array is ascending order now.
	 * 终止：根据初始化和保持，可以确定终止时，数组是升序排列的。
	 * 
	 * @param array
	 * 			  array  waiting for sort
	 *            待排序数组
	 */
	private static void insertSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j;
			// 待插入数据
			int key = array[i];
			// 只要待插入数据比比较数据小，则将比较数据向后移动一个位置
			for (j = i - 1; j >= 0 && key < array[j]; j--) {
				array[j + 1] = array[j];
			}
			// 把待插入数据，放置到正确的位置
			array[j + 1] = key;
		}
	}

	public static void main(String args[]) {
		int[] array = new int[50];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(20);
		}
		System.out.println(Arrays.toString(array));
		insertSort(array);
		System.out.println(Arrays.toString(array));
	}

}
