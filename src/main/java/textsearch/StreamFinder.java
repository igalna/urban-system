package main.java.textsearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFinder implements Finder{

	public List<Result> processInputFile(String fileName, String[] searchTerms) {
		
		List<Result> results = new ArrayList<>();
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			results = stream.filter(line -> streamContains(line, searchTerms))
					.map(line -> getFristTwoElements(line))
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	private boolean streamContains(String string, String[] searchTerms) {
		for (String s : searchTerms){
			if (string.toLowerCase().contains(s.toLowerCase()))
				return true;
		}
		return false;
	}
	
	private Result getFristTwoElements(String string) {
		String[] strings = string.split(",");
		return new Result(strings[0], strings[1]);
	}
}