package com.sk.practice.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GenericExample1 {

	//Collection 에서 요소를 꺼내와 어떤 특별한 동작을 하지 않는 경우, wildcard
	static boolean isEmpty(List<?> list) {
		return list.size()==0;
	}
	
	static long frequency(List<?> list, Object item) {
		return list.stream().filter(s -> s.equals(item)).count();
	}
	
	//Collection에서 꺼내와 사용되어 지는 요소는 T의 하위타입어야 한다. 
	//반면 Comparable은 T의 상위타입이어야 한다.
	static <T extends Comparable<? super T>> T max(List<? extends T> list) {
		return list.stream().reduce((x, y) -> x.compareTo(y) > 0 ? x:y).get();
	}
	
	//API용은 wild card를 써주는게 좋다.
	static void reverse(List<?> list) {
		reverseHelper(list);
		//아래 소스에서 캡처 오류 발생
//		List<?> temp = new ArrayList<>(list);
//		for(int i = 0; i < list.size(); i++) {
//			list.set(i, temp.get(list.size()-i));//타입추론이 되지 않는다.
//		}
	}
	
	//캡처링(타입추론)을 위해 헬퍼 메서드 사용
	private static <T> void reverseHelper(List<T> list) {
		List<T> temp = new ArrayList<>(list);
		for(int i = 0; i < list.size(); i++) {
			list.set(i, temp.get(list.size()-i-1));//
		}
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 1, 2, 3, 3, 4, 5);
		//List<Integer>에서 값을 꺼내와, Number 에 담는다. Number는 Integer 의 상위타입이다.
		Number max = max(list);
		reverse(list);
		System.out.println(list);
		
		Map emptyMap = Collections.EMPTY_MAP;
	}
}
