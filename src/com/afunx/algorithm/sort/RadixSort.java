package com.afunx.algorithm.sort;

import java.util.Arrays;

import com.afunx.algorithm.util.ArrayUtils;

public class RadixSort {

	public static void main(String args[]) {
		final int size = 30;
		final int count = 20;
		int[] sourceArray = ArrayUtils.generateRandomArray(size, count);
		int[] copyArray = Arrays.copyOf(sourceArray, sourceArray.length);
		ArrayUtils.printArray(sourceArray);
		radixSort(sourceArray);
		ArrayUtils.printArray(sourceArray);
		System.out.println(ArrayUtils.isAsendingOrder(sourceArray) && ArrayUtils.isArrayContentEqual(sourceArray, copyArray));
	}

	private static void radixSort(int[] array) {
		// system(10 means decimal system)
		final int d = 10;
		boolean exit;
		int k;
		final int[][] tempArray = new int[d][array.length];
		final int[] countArray = new int[d];
		int n = 1;

		do {
			// whether exit the while loop
			exit = true;
			// find bucket and place array into tempArray
			for(int i=0; i<array.length; i++) {
				int bucket = array[i] / n % d;
				if(exit && bucket > 0) {
					exit = false;
				}
				tempArray[bucket][countArray[bucket]++] = array[i];
			}

			// index for array
			k = 0;
			// place array from tempArray
			for(int i=0; i<countArray.length; i++) {
				for(int j=0; j<countArray[i]; j++) {
					array[k++] = tempArray[i][j];
				}
				// clear countArray[i]
				countArray[i] = 0;
			}
			// update n for calculate bucket
			n *= d;
		} while(!exit);
	}
}
