package edu.easternct.junit;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class ExampleStaticMethodsTest {

	@Test
	public void testReverseString() {
		
		String reverse = ExampleStaticMethods.reverseString("Hello World");
		assertThat(reverse, either(containsString("dlroW olleH")).or(containsString("dlrow olleh")).or(containsString("dlrowolleh")));
	}

//	@Test
	public void testReverseStringFail() {

		String reverse = ExampleStaticMethods.wrongReverseString("Hello World");
		assertThat(reverse, either(containsString("dlroW olleH")).or(containsString("dlrow olleh")).or(containsString("dlrowolleh")));
	}

	@Test
	public void testSummation() {

		int[] arg = {1,2,3,4};
		int sum = ExampleStaticMethods.summation(arg);

		assertThat(sum, is(10));
	}

//	@Test
	public void testSummationFail() {

		int[] arg = {1,2,3,4};
		int sum = ExampleStaticMethods.wrongSummation(arg);

		assertThat(sum, is(10));
	}
}

