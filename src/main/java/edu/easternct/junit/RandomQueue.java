package edu.easternct.junit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomQueue<T> implements Iterable<T> {

	private Random rand;
	private List<T> queue;
	private int nextItem;
	private boolean hasPopped;

	private void getNext() {

		nextItem = rand.nextInt(queue.size());
		hasPopped = false;
	}

	public RandomQueue() {
	
		this.queue = new ArrayList<T>();
		this.nextItem = 0;
		this.hasPopped = true;
		this.rand = new Random();
	}

	public boolean isEmpty() {

		return queue.size() < 1;
	}

	public int size() {

		return queue.size();
	}

	public void enqueue(T element) {

		queue.add(element);
	}

	public T peek() {

		if (isEmpty()) {

			throw new IllegalStateException("No elements to peek at");
		}

		if (hasPopped) {
			
			getNext();
		}

		return queue.get(nextItem);
	}

	public T dequeue() {

		if (isEmpty()) {

			throw new IllegalStateException("No elements to dequeue");
		}

		if (hasPopped) {

			getNext();
		}

		T retval = queue.get(nextItem);
		queue.remove(nextItem);
		hasPopped = true;
		return retval;
	}

	public Iterator<T> iterator() {
		if (isEmpty()) {

			throw new IllegalStateException("No elements to peek at");
		}

		hasPopped = true;
		return new RandomIterator<T>(queue);
	}
}
