package com.sk.basic.type;

import java.io.FileInputStream;
import java.io.IOException;

public class CharReadFromFile {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("src/main/resources/data.txt");
		int read;
		while((read = fis.read())!=-1) { //UTF인코딩된 파일이므로, 한글 3글자는 9byte가 읽혀진다.
			System.out.println(read);
		}
		fis.close();
	}
}