package com.afunx.algorithm.other;

public class DaShuXiangCheng {
	public static void main(String args[]) {
		int a = Integer.MIN_VALUE;
		int b = Integer.MIN_VALUE;
		String result = multiple(a, b);
		long aL = a;
		long bL = b;
		long resultL = aL * bL;
		System.out.println(resultL);
		System.out.println(result);
	}

	private static String multiple(int a, int b) {
		if (a == 0 || b == 0) {
			return "0";
		}
		boolean positive = a > 0 && b > 0 || a < 0 && b < 0;
		String aStr = getStr(a);
		String bStr = getStr(b);
		aStr = reverse(aStr);
		bStr = reverse(bStr);
		System.out.println("aStr: " + aStr + ",bStr: " + bStr);
		int aLen = aStr.length();
		int bLen = aStr.length();
		int[] values = new int[aLen + bLen];
		int a0, b0;
		for (int i = 0; i < aLen; i++) {
			a0 = Integer.parseInt(aStr.substring(i, i + 1));
			for (int j = 0; j < bLen; j++) {
				b0 = Integer.parseInt(bStr.substring(j, j + 1));
				values[i + j] += a0 * b0;
			}
		}
		for (int i = 1; i < values.length; i++) {
			values[i] += values[i - 1] / 10;
			values[i - 1] %= 10;
		}
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		for (int i = values.length - 1; i >= 0; i--) {
			if (flag) {
				if (values[i] == 0) {
					continue;
				} else {
					flag = false;
				}
			}
			sb.append(values[i]);
		}
		if (positive) {
			return sb.toString();
		} else {
			return "-" + sb.toString();
		}
	}

	private static String reverse(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

	private static String getStr(int i) {
		if (i > 0) {
			return Integer.toString(i);
		} else {
			return Integer.toString(i).substring(1);
		}
	}
}
