package edu.easternct.junit;

import org.junit.Test;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.*;

public class RandomQueueTest {

	public RandomQueue<Integer> initQueue() {

		RandomQueue<Integer> rqueue = new RandomQueue<Integer>();
		Collection<Integer> testValues = Arrays.asList(1,2,3,4,5,6,7,8,9);
		for (int val : testValues) {
			
			rqueue.enqueue(val);
		}

		return rqueue;
	}

	@Test
	public void testEnqueuing() {

		RandomQueue<Integer> rqueue = initQueue();

		assertThat(rqueue.size(), is(9));
	}
	
	@Test
	public void testDequeuing() {

		RandomQueue<Integer> rqueue = initQueue();	
		Collection<Integer> testValues = Arrays.asList(1,2,3,4,5,6,7,8,9);

		assertThat(rqueue.size(), is(9));
		for (int i=0; i<9; ++i) {

			int val = rqueue.dequeue();
			assertThat(val, isIn(testValues));
//			System.out.printf("%d ",val);
		}

		assertThat(rqueue.isEmpty(), is(true));
//		System.out.println();
	}

	@Test
	public void testIterator() {
	
		RandomQueue<Integer> rqueue = initQueue();	

		for (Integer val : rqueue) {

			assertThat(val, both(greaterThan(0)).and(lessThan(10)));
//			System.out.printf("%d ",val);
		}
//		System.out.println();
	}

	@Test(expected= IllegalStateException.class)
	public void testThrowException() {

		RandomQueue<Integer> rqueue = new RandomQueue<Integer>();

		rqueue.peek();
	}

	@Test
	public void testRandom() {

		int ones = 0;
		for (int i=0; i<1000; ++i) {
			RandomQueue<Integer> rqueue = new RandomQueue<Integer>();
			rqueue.enqueue(1);
			rqueue.enqueue(2);
			if (rqueue.dequeue() == 1) {
				
				++ones;
			}
		}
//		System.out.println(ones);
		assertThat(ones, is(both(lessThan(550)).and(greaterThan(450))));
	}
}
