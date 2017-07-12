package main.java.textsearch;

import java.util.Arrays;

public class Search {

	public static void main(String[] args) {
		
		String fileName;
		String[] searchTerms;
		Finder finder;
		
		if (args.length	< 2)
			System.out.printf("Usage : <%s> <file to search> <terms to search for>.", Search.class.getSimpleName().toString());
		
		else {
			String homeDir = new String(System.getProperty("user.home"));
			fileName = homeDir + args[0];
			System.out.println("FileName : " + fileName);
			searchTerms = new String[args.length-1];
			for (int argListIndex = 1; argListIndex < args.length; argListIndex++) {
				searchTerms[argListIndex-1] = args[argListIndex];
			}
			System.out.println("Search terms : " + Arrays.toString(searchTerms));
			
			finder = new Finder();
			finder.processInputFile(fileName, searchTerms);
		}
	}
}