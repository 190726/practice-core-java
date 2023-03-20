package com.sk.practice.interfaces;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * Set 은 중복요소를 허용하지 않는 Collection 이다. 
 */
public class SetInterface {
	
	/*Collection의 중복 없애기*/
	public static <E> Set<E> removeDups(Collection<E> c){
		return new LinkedHashSet<>(c); //HashSet은 삽입순서를 관리하지 않지만, LinkedHashSet은 삽입순서를 관리하여, 출력할때 삽입순서대로 출력된다.
	}
}
