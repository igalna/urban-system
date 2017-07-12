package main.java.textsearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Finder {

	public void processInputFile(String fileName, String[] searchTerms) {
		
		List<String> list = new ArrayList<>();
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			list = stream.filter(line -> streamContains(line, searchTerms))
					.map(line -> getFristTwoElements(line))
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String result : list)
			System.out.println(result);
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
