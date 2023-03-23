package com.sk.io.path;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FilePathFilter {
	
	enum FilterType{
		File,All;
	}
	
	private Path target;
	private List<String> allowedExtensions;
	private FilterType type;
	private List<Path> filteredPaths = new ArrayList<>();
	
	public FilePathFilter(Path target, List<String> allowedExtensions, FilterType type) {
		this.target = target;
		this.allowedExtensions = allowedExtensions;
		this.type = type;
	}

	public List<Path> filteredPath(){
		listOfDirectory(target, filter());
		return filteredPaths;
	}
	
	private void listOfDirectory(Path path, DirectoryStream.Filter<Path> filter) {
		
		try(DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path, filter);){
			newDirectoryStream.forEach(p -> {
				boolean isDir = Files.isDirectory(p);
				if(isDir) listOfDirectory(p, filter);
				if(type == FilterType.File) {
					if(!isDir)filteredPaths.add(p);
				}else {
					filteredPaths.add(p);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private DirectoryStream.Filter<Path> filter() {
		return new DirectoryStream.Filter<Path>(){
			@Override
			public boolean accept(Path entry) throws IOException {
				if(Files.isDirectory(entry)) return true;
				if(allowedExtensions.stream().anyMatch(ext-> entry.getFileName().toString().endsWith(ext))) return true;
				return false;
			}
		};
	}
}
