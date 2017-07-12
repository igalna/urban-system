package main.java.textsearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Finder {

	public void processInputFile(String fileName, String[] searchTerms) {
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.filter(line -> streamContains(line, searchTerms))
					.map(line -> getFristTwoElements(line))
					.collect(Collectors.toList())
					.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean streamContains(String string, String[] searchTerms) {
		for (String s : searchTerms){
			if (string.toLowerCase().contains(s.toLowerCase()))
				return true;
		}
		return false;
	}
	
	private String getFristTwoElements(String string) {
		String[] strings = string.split(",");
		return Arrays.toString(Arrays.copyOf(strings, strings.length-1));
		
	}
}
