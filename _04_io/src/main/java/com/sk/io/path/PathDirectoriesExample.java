package com.sk.io.path;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class PathDirectoriesExample {
	
	public static void main(String[] args) throws IOException {
		//directoryCreated();
		//all list
		//listOfDirectory(Paths.get("src/main/java/com/sk/io/path"));
		//filtered list
		//listOfDirectory(Paths.get("src/main/java/com/sk/io/path"), "*.{java2,class,tmp}");
		
//		String[] allowedExtentions = {"txt","java","tmp"};
//		System.out.println(			
//				Arrays.stream(allowedExtentions).anyMatch(ext -> "hello.java".endsWith(ext))
//		);
	}
	
	public static void directoryCreated() throws IOException {
		// 1. 전통적인 디렉토리 생성
		File oldDir = new File("e:/temp/subtemp");
		boolean resultMkdir = oldDir.mkdir();
		System.out.println(resultMkdir);
		
		//2. Files를 이용한 디렉토리 생성
		//   - Nested Directory 생성이 가능하다.
		//   - 생성실패 오류를 비교적 명확하게 던저준다.
		Path newDir = Paths.get("e:/temp/subtemp");
		if(Files.notExists(newDir)) {
			try {
				Path createDirectories = Files.createDirectories(newDir);
				System.out.println(createDirectories.toRealPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}