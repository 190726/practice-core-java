package com.sk.practice.interfaces;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class SetInterfaceTest {

	@Test
	void _문자열배열_요소의_중복없애기() {
		String[] samples = stub();
		//1. 중복되는 요소를 제거하기
		Set<String> uniques = new HashSet<>();
		Set<String> dups = new HashSet<>();
		
		for(String str : samples)
			if(!uniques.add(str)) dups.add(str);
		
		uniques.removeAll(dups);
		assertEquals(uniques.size(), 2);
	}
	
	@Test
	void _문자열배열_요소의_중복없애기2() {
		Set<String> result = Arrays.stream(stub()).collect(Collectors.toSet());
		assertEquals(result.size(), 3);
	}
	
	@Test
	void _문자열배열_요소의_중복없애기3() {
		List<String> lists = Arrays.asList(stub());
		Set<String> removeDups = SetInterface.removeDups(lists);
		assertEquals(removeDups.size(), 3);
	}
	
	private static String[] stub() {
		return new String[]{"lee","kimm","lee","pak"};
	}
}
