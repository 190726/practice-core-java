package com.sk.basic.interable;

import java.util.Iterator;

public class IterableTest {
	
	public static void main(String[] args) {
		CustomIterable c = new CustomIterable();
		printForIterable(c);
	}
	
	static void printForIterable(Iterable<?> iter) {
		Iterator<?> iterator = iter.iterator();
		while(iterator.hasNext()) System.out.println(iterator.next());
	}
	
	static class CustomIterable implements Iterable<Integer>{
		
		Iterator<Integer> iterator;
		Integer num = 0;
		
		public CustomIterable() {
			iterator = new Iterator<Integer>() {

				@Override
				public boolean hasNext() {
					return num < 10;
				}
				@Override
				public Integer next() {
					return num++;
				}
			};
		}

		@Override
		public Iterator<Integer> iterator() {
			return iterator;
		}
	}
}