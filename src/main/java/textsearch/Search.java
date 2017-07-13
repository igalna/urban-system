package main.java.textsearch;

import java.util.Arrays;
import java.util.List;

public class Search {

	public static void main(String[] args) {
		
		String fileName;
		String[] searchTerms;
		Finder finder;
		ResultOutput output;
		
		if (args.length	< 2)
			System.out.printf("Usage : <%s> <file to search> <terms to search for>.", Search.class.getSimpleName().toString());
		
		else {
			fileName = args[0];
			System.out.println("FileName : " + fileName);
			
			searchTerms = new String[args.length-1];
			for (int argListIndex = 1; argListIndex < args.length; argListIndex++) {
				searchTerms[argListIndex-1] = args[argListIndex];
			}
			System.out.println("Search terms : " + Arrays.toString(searchTerms));
			
			//finder = new CallableFinder();
			finder = new StreamFinder();
			List<Result> results = finder.processInputFile(fileName, searchTerms);
			
			output = new ConsolePrintOutput();
			output.output(results);
			
			
			
		}
	}
}