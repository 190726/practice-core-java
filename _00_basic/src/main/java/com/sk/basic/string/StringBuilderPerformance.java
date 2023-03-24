package com.sk.basic.string;

public class StringBuilderPerformance {
	
	private static final int NUMBER = 1_000_000;

	public static void main(String[] args) {
		//String 106초
		userString();
		//StringBuilder 8ms
		userStringBuilder();
		//StringBuffer 23ms
		userStringBuffer();
	}

	private static void userString() {
		long startTime = System.currentTimeMillis();
		
		String word = "";
		for(int i = 0; i < NUMBER; i++) {
			word += "*";
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println((endTime-startTime));
	}
	
	private static void userStringBuilder() {
		long startTime = System.currentTimeMillis();
		
		StringBuilder word = new StringBuilder();
		for(int i = 0; i < NUMBER; i++) {
			word.append("*");
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println((endTime-startTime));
	}
	
	private static void userStringBuffer() {
		long startTime = System.currentTimeMillis();
		
		StringBuffer word = new StringBuffer();
		for(int i = 0; i < NUMBER; i++) {
			word.append("*");
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println((endTime-startTime));
	}
}