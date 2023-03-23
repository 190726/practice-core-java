package com.sk.io.path;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class PathMetaDataExample {
	
	public static void main(String[] args) {
		
	}
	
	public static void attributesFromPath() {
		Path path = FileSystems.getDefault().getPath("pom.xml");
		try {
			BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
			System.out.format("createTime: %s%n", attributes.creationTime());
			System.out.format("lastAccessTime: %s%n", attributes.lastAccessTime());
			System.out.format("lastModifiedTime: %s%n", attributes.lastModifiedTime());
			System.out.format("isDirectory: %s%n", attributes.isDirectory());
			System.out.format("isRegularFile: %s%n", attributes.isRegularFile());
			System.out.format("isSymbolicLink: %s%n", attributes.isSymbolicLink());
			System.out.format("size: %s%n", attributes.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void basicPathTest() {
		Path p2 = Paths.get(URI.create("file:///D:/win10Dev/eclipse23/workspace/practice-core-java/_04_io/src/main/java/com/sk/io/path/PathExample.java"));
		Path p3 = FileSystems.getDefault().getPath("pom.xml");
		System.out.format("getFileName: %s%n",p2.getFileName());
		System.out.format("toString(): %s%n",p2.toString());
		System.out.format("getName(0): %s%n",p2.getName(0));
		System.out.format("getParent(): %s%n",p2.getParent());
		System.out.format("getRoot(): %s%n",p2.getRoot());
		try {
			//toRealPath 메서드는 실제 경로를 반환한다. 경로가 존재하지 않으면 Exception
			System.out.format("getRoot(): %s%n",p3.toRealPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void moveFileTest() {
		Path source = Paths.get("data.txt");
		Path target = Paths.get("data2.txt");
		try {
			Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void copyFileTest() {
		Path source = Paths.get("data.txt");
		Path target = Paths.get("data2.txt");
		try {
			Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
