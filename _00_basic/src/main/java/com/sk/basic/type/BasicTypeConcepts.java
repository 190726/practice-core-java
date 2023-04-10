package com.sk.basic.type;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * 
 * byte |  1byte | -128~127
 * char |  2byte | 0~65535
 * byte |  1byte | -128~127
 * byte |  1byte | -128~127
 * 
 *
 */
public class BasicTypeConcepts {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		writeToWayBinary();
		toUnicodeTest();
	}
	
	public static void writeToWayBinary() {
		
		System.out.println("[1] 소문자 a");
		int binaryInt = 0b1100001;
		log(binaryInt);
		
		System.out.println("\n[2] 1번값을 왼쪽으로 8비트 shift");
		int shiftInt = binaryInt << 8;
		log(shiftInt);
		
		System.out.println("\n[3] '가'를 16진수법으로 표현");
		int hexInt = 0xAC00;
		log(hexInt);
		
		System.out.println("\n[3] hexInt 를 UTF8 인코딩한 2진수로 표현");
		//hexInt 를 UTF8 인코딩한 2진수로 표현
		//1110xxxx 10xxxxxx 10xxxxxx
		//1010 110000 000000를 인코딩 하게 되면
		//111010101011000010000000
		int utf8Encode = 0b1111010101011000010000000;
		log(utf8Encode);
		
		byte[] toByte = ByteBuffer.allocate(4).putInt(utf8Encode).array();//
		System.out.println("--> '가'를 3byte UTF8로 인코딩한 값 출력");
		for(byte b : toByte) {
			System.out.print(b & 0xff); //byte를 int 로 업캐스팅
			System.out.print(' ');
		}
	}
	
	private static void toUnicodeTest() throws UnsupportedEncodingException {
		System.out.println("\n-------------한글('가') to 유니코드-----------");
		String str = "가";
		byte[] strBytes8 = str.getBytes();
		for(byte b : strBytes8) {
			System.out.print(String.format("0x%02X", b)); //16진수로 표현
			System.out.print(':');
			System.out.print(b & 0xff);
			System.out.print(' ');
		}
		System.out.println();
		
		//한글 to 16진수 유니코드
		System.out.println(String.format("U+%04X", "가".codePointAt(0)));
		System.out.println("\n-------------유니코드('가') to 한글-----------");
		String unicode1 = "\uAC00";
		byte[] _byteUnicode1 = unicode1.getBytes("UTF-8");
		System.out.println(new String(_byteUnicode1, Charset.forName("UTF-8")));
		for(byte b : _byteUnicode1) {
			System.out.print(b & 0xff);
			System.out.print(' ');
		}
	}

	private static void log(int integer) {
		System.out.println("2진수 %s | 16진수 %s | 10진수 %s | unicode char %s".formatted(Integer.toBinaryString(integer) ,
				Integer.toHexString(integer),
				integer,
				(char)integer));
	}
}