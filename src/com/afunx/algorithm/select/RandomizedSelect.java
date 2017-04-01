package com.afunx.algorithm.select;

import java.util.Arrays;
import java.util.Random;

public class RandomizedSelect {

	public static void main(String args[]) {
		
		int[] array = new int[50];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(20);
		}
		
		int[] newArray = new int[50];
		for (int k = 0; k < array.length; k++) {
			int value = randominzedSelect(array, 0, array.length - 1, k);
			newArray[k] = value;
		}
		
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(newArray));
	}

	private static int randominzedSelect(int[] array, int p, int r, int i) {
		if (p == r) {
			return array[p];
		}
		int q = randomPartition(array, p, r);
		int k = q - p;
		if (i == k) {
			return array[q];
		} else if (i < k) {
			return randominzedSelect(array, p, q - 1, i);
		} else {
			return randominzedSelect(array, q + 1, r, i - k - 1);
		}
	}

	private static int randomPartition(int[] array, int p, int r) {
		// randomized
		Random random = new Random();
		int randomR = p + random.nextInt(r - p + 1);
		swap(array, randomR, r);
		
		
		int k = p - 1;
		int key = array[r];
		for (int i = p; i < r; i++) {
			if (array[i] < key) {
				swap(array, ++k, i);
			}
		}
		swap(array, ++k, r);
		return k;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
