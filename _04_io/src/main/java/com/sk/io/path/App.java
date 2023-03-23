package com.sk.io.path;

import java.nio.file.Paths;
import java.util.Arrays;

public class App {
	
	public static void main(String[] args) {
		FilePathFilter filter = new FilePathFilter(
										Paths.get("D:\\업무자료\\채널지원-공통"), //타겟 경로
										Arrays.asList("xlsx"), //확장자
										FilePathFilter.FilterType.File); //파일, 전체
		filter.filteredPath().forEach(System.out::println);
	}
}
