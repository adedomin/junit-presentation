package edu.easternct.junit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class RandomIterator<T> implements Iterator<T> {

	private int index;
	private int end;
	List<T> list;

	public RandomIterator(List<T> list) {

		this.list = new ArrayList<T>(list);
		Collections.shuffle(this.list);
		this.index = 0;
		this.end = list.size();
	}

	public boolean hasNext() {
		
		if (index < end) {
			return true;
		}

		return false;
	}

	public T next() {
		
		if (hasNext()) {
			
			return list.get(index++);
		}

		throw new NoSuchElementException("out of bounds");
	}
}
