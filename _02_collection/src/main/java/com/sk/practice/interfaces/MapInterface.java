package com.sk.practice.interfaces;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.sk.practice.model.Party;
import com.sk.practice.model.Person;

public class MapInterface {
	
	public static void main(String[] args) {
		//Collection View
		//Map에서는 3개의 컬렉션뷰를 제공한다. 
		//1. keySet
		//2. EntrySet
		//3. values
		printMapByKeyset(getPersonsGroupingByParty());
		printMapByEntrySet(getPersonsGroupingByParty());
		values(getPersonsGroupingByParty());
		
	}
	
	public static <T, R> void printMapByKeyset(Map<T, R> map) {
		System.out.println("----printMapByKeyset------");
		for(T key : map.keySet()) {
			System.out.println(key + ":"+ map.get(key));
		}
		System.out.println();
	}
	
	public static <T, R> void printMapByEntrySet(Map<T, R> map) {
		System.out.println("----printMapByKeyset------");
		for(Entry<T, R> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
		System.out.println();
	}
	
	public static <T, R> void values(Map<T, R> map) {
		System.out.println("----values------");
		System.out.println(map.values());
	}
	
	public static Map<Party, List<Person>> getPersonsGroupingByParty(){
		return Person.stub().stream().collect(Collectors.groupingBy(Person::getParty));
	}
}
