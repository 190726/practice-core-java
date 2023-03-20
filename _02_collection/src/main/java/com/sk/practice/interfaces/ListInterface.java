package com.sk.practice.interfaces;

import java.util.List;
import java.util.Random;

public class ListInterface {
	
	public static <T> void swap(List<T> list, int i, int j) {
		T tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}
	
	public static <T> void shuffle(List<T> list) {
		Random random = new Random();
		for(int i=list.size(); i > 1; i--) {
			swap(list, i-1, random.nextInt(i));
		}
	}
}