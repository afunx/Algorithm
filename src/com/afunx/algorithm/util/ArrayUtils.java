package com.afunx.algorithm.util;

import java.util.Random;

public class ArrayUtils {

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static int[] generateRandomArray(int size) {
		return generateRandomArray(size, 30);
	}
	
	public static int[] generateRandomArray(int size, int max) {
		Random random = new Random();
		int[] array = new int[size];
		for(int i=0;i<array.length;i++) {
			array[i] = random.nextInt(max);
		}
		return array;	
	}
	
	public static void printArray(int[] array) {
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static boolean isAsendingOrder(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			if(array[i] > array[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isDescendingOrder(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			if(array[i] < array[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * check whether two arrays are the same content, maybe not the same order
	 * @param array1	array to be checked
	 * @param array2	array to be checked
	 * @return	whether two arrays are the same content, maybe not the same order
	 */
	public static boolean isArrayContentEqual(int[] array1, int[] array2) {
		if(array1.length != array2.length) {
			return false;
		}
		int length = array1.length;
		boolean[] used = new boolean[length];
		for(int i1=0; i1<length; i1++) {
			int key1 = array1[i1];
			boolean contains1 = false;
			for(int i2=0; i2<length; i2++) {
				if(used[i2]) {
					continue;
				}
				if(key1==array2[i2]) {
					used[i2] = true;
					contains1 = true;
					break;
				}
			}
			if(!contains1) {
				return false;
			}
		}
		return true;
	}
}
