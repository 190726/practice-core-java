package com.sk.practice.interfaces;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Set 은 중복요소를 허용하지 않는 Collection 이다. 
 */
public class SetInterface {
	
	public static void main(String[] args) {
		String[] strs = {"lee","kimm","lee","pak"};
		Set<String> result = Arrays.stream(strs).collect(Collectors.toSet());
		System.out.println(result);
	}
}
