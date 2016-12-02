package com.afunx.algorithm.datastructure;

import java.util.Arrays;
import java.util.Random;

public class PriorityQueue {

	private final int[] mKeys = new int[100];
	private int mSize = 0;

	public void mock(int size) {
		mSize = size;
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			mKeys[i] = 10 + random.nextInt(20);
		}
	}

	public void print() {
		final int[] array = new int[mSize];
		System.arraycopy(mKeys, 0, array, 0, mSize);
		System.out.println("print tree start");
		System.out.println(Arrays.toString(array));
		for (int i = 0; i < mSize; i++) {
			int leftIndex = 2 * i + 1;
			int rightIndex = 2 * i + 2;
			if (leftIndex >= mSize) {
				// no child
				continue;
			}
			for(int k=0;k<(i+1)/2;k++) {
				System.out.print("     ");
			}
			System.out.print(array[i] + " :");
			System.out.print(" " + array[leftIndex]);
			if (rightIndex < mSize) {
				System.out.print(" , " + array[rightIndex]);
			}
			System.out.println();
		}
		System.out.println("print tree end");
	}

	public int peekMax() {
		if (mSize == 0) {
			throw new RuntimeException("size is 0");
		}
		int key = mKeys[0];
		return key;
	}
	
	public int extractMax() {
		if (mSize == 0) {
			throw new RuntimeException("size is 0");
		}
		int key = mKeys[0];
		if (mSize > 1) {
			mKeys[0] = mKeys[--mSize];
			heapifyMax(mKeys, mSize, 0);
		} else {
			--mSize;
		}
		return key;
	}

	private int left(int i) {
		return 2 * i + 1;
	}
	
	private int right(int i) {
		return 2 * i + 2;
	}
	
	private int parent(int i) {
		return (i - 1) / 2;
	}
	
	private void heapifyMax(int[] array, int heapSize, int i) {
		int max = i;
		int left = left(i);
		int right = right(i);

		if (left < heapSize && array[left] > array[max]) {
			max = left;
		}

		if (right < heapSize && array[right] > array[max]) {
			max = right;
		}

		if (max != i) {
			int temp = array[i];
			array[i] = array[max];
			array[max] = temp;
			heapifyMax(array, heapSize, max);
		}
	}

	public void upgrade(int index, int newKey) {
		int oldKey = mKeys[index];
		if (newKey < oldKey) {
			throw new RuntimeException("newKey < oldKey");
		}
		mKeys[index] = newKey;
		int p = parent(index);
		while (p >= 0 && mKeys[p] < mKeys[index]) {
			int temp = mKeys[p];
			mKeys[p] = mKeys[index];
			mKeys[index] = temp;
			index = p;
			p = parent(p);
		}
	}

	public void add(int key) {
		mKeys[mSize++] = Integer.MIN_VALUE;
		upgrade(mSize-1, key);
	}
	
	public static void main(String args[]) {
		PriorityQueue queue = new PriorityQueue();
		
		Random random = new Random();
		final int capacity = 10;
		final int max = 20;
		for(int i=0;i<capacity;i++) {
			queue.add(random.nextInt(max));
		}
		for(int i=0;i<capacity;i++) {
			System.out.println(queue.extractMax());
		}
	}
}
