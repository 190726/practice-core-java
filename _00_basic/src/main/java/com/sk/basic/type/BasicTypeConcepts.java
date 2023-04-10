package com.sk.basic.type;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 
 * byte |  1byte | -128~127
 * char |  2byte | 0~65535
 * int |  4byte | -2147483648 ~ 2147483648
 * long |  8byte | 
 * 
 *
 */
public class BasicTypeConcepts {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		writeToWayChar();
		writeToWayBinary();
		toUnicodeTest();
	}
	
	public static void writeToWayChar() {
		char c1 = 'A';
		char c2 = 65;
		char c3 = '\u0041';
		System.out.println(c1);//A
		System.out.println(c2);//A
		System.out.println(c3);//A
		
		char c4 = '가';
		char c5 = 44032;
		char c6 = '\uac00';
		System.out.println(c4);//가
		System.out.println(c5);//가
		System.out.println(c6);//가
		
		//2byte char 를 byte[2]로 변환한 후, String(UTF16으로 변환)
		byte[] b = new byte[2];
		
		b[1] = (byte) c4;
		//10101100 00000000 => 00000000 10101100
		//10101100 0000000
		b[0] = (byte)(c4 >> 8);
		
		System.out.println(Integer.toBinaryString(c4 >> 1));//이진수 각 자리를 오른쪽으로 1칸씩 밀면서 사라지는 자리는 삭제
		System.out.println(Integer.toBinaryString(c4 >> 2));
		System.out.println(Integer.toBinaryString(c4 >> 3));
		System.out.println(Integer.toBinaryString(c4 >> 4));
		System.out.println(Integer.toBinaryString(c4 << 1));
		System.out.println(Integer.toBinaryString(c4 << 2));//이진수 각 자리를 오니쪽으로 밀면서 첫번째 자리를 0으로 채워나간다.
		System.out.println(b[0] & 0xff);
		System.out.println(b[1] & 0xff);
		System.out.println("16진수 :" + new String(b, StandardCharsets.UTF_16));
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
		
		//한글 to 16진수 유니코드(char 타입은 2byte이며, 유니코드도 2byte)
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