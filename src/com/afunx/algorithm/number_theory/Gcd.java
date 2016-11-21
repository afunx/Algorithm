package com.afunx.algorithm.number_theory;

/**
 * refer to http://www.cnblogs.com/linyujun/p/5167914.html
 * 
 * @author afunx
 *
 */
public class Gcd {

	private static int gcd2(int a, int b) {
		int t;
		while (b != 0) {
			t = b;
			b = a % b;
			a = t;
		}
		return a;
	}

	private static int gcd1(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd1(b, a % b);
		}
	}

	public static void main(String args[]) {
		int a = 9, b = 12;
		int gcd = gcd1(a, b);
		System.out.println(gcd);
	}
}
