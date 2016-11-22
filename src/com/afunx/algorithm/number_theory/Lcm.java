package com.afunx.algorithm.number_theory;

/**
 * refer to http://www.cnblogs.com/linyujun/p/5167914.html
 * 
 * @author afunx
 *
 */
public class Lcm {
	public static void main(String args[]) {
		int a = 10;
		int b = 15;
		int lcm = lcm(a, b);
		System.out.println(lcm);
	}

	private static int gcd(int a, int b) {
		int t;
		while (b != 0) {
			t = b;
			b = a % b;
			a = t;
		}
		return a;
	}

	// lcm * gcd = a * b
	private static int lcm(int a, int b) {
		int gcd = gcd(a, b);
		return a / gcd * b;
	}
}
