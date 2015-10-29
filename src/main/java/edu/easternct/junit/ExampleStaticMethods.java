package edu.easternct.junit;

public class ExampleStaticMethods {

	public static String reverseString(String str) {

		return new StringBuilder(str).reverse().toString();
	}

	public static String wrongReverseString(String str) {

		return str;
	}

	public static int summation(int[] values) {

		int sum = 0;
		for (int val : values) {

			sum += val;
		}
		return sum;
	}

	public static int wrongSummation(int[] values) {

		int notSum = 0;
		for (int val : values) {

			notSum -= val;
		}
		return notSum;
	}
}
