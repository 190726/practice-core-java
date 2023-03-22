package com.sk.practice.implement;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 1. HashSet : 중복을 허용하지 않음, 순서를 보장하지 않음
 * 2. TreeSet : 순서를 보장
 * 3. LinkedHashSet : 입력한 순서대로 꺼내옴
 * 4. EnumSet : enum을 위한 고성능 set 구현체로 동일 enum Type 만 적용
 * 
 * @author 190726
 *
 */
public class SetImplements {
	
	public static void main(String[] args) {
		Integer[] nums = {8, 1, 2, 3, 4, 5,  3,  4, 5};
		
		Set<Integer> hashSet = hashSet(Arrays.asList(nums));
		System.out.println(hashSet);
		
		Set<Integer> numsSet = treeSet(Arrays.asList(nums));
		System.out.println(numsSet);
		
		Set<Integer> linkedHashSet = linkedHashSet(Arrays.asList(nums));
		System.out.println(linkedHashSet);
		
		String[] strs = {"a", "z", "d", "a", "r", "d", "w" };
		
		Set<String> hashSet2 = hashSet(Arrays.asList(strs));
		System.out.println(hashSet2);
		
		Set<String> numsSet2 = treeSet(Arrays.asList(strs));
		System.out.println(numsSet2);
		
		Set<String> linkedHashSet2 = linkedHashSet(Arrays.asList(strs));
		System.out.println(linkedHashSet2);
		
		EnumSet<Color> allOf = EnumSet.allOf(Color.class);
		
		enumSetTest(allOf);
		
		for(Color color :  EnumSet.range(Color.YELLOW, Color.BLACK)) {
			System.out.println(color);
		}
		
	}
	
	private static <T> Set<T> hashSet(Collection<T> collection) {
		return new HashSet<>(collection);
	}
	
	private static <T> Set<T> treeSet(Collection<T> collection) {
		return new TreeSet<>(collection);
	}
	
	private static <T> Set<T> linkedHashSet(Collection<T> collection) {
		return new LinkedHashSet<>(collection);
	}
	
	//EnumSet을 인자로 받을 것이 예측된다 하더라도, Set 인터페이스 타입으로 선언하는 것이 좋다.
	private static void enumSetTest(Set<Color> set) {
		System.out.println(set);
		
	}
	
	public enum Color{
		RED ,YELLOW, BLUE, BLACK, WHITE;
	}

}
