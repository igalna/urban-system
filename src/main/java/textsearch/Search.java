package main.java.textsearch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Search {

	public static void main(String[] args) {
		
		String fileName;
		String[] searchTerms;
		
		if (args.length	< 2)
			System.out.printf("Usage : <%s> <file to search> <terms to search for>.", Search.class.getSimpleName().toString());
		
		else {
			fileName = args[0];
			String homeDir = new String(System.getProperty("user.home"));
			System.out.println(homeDir);
			try (BufferedReader br = new BufferedReader(new FileReader(homeDir + fileName))) {
				fileName = args[0];
				System.out.println("FileName : " + fileName);
				searchTerms = new String[args.length-1];
				for (int argListIndex = 1; argListIndex < args.length; argListIndex++) {
					searchTerms[argListIndex-1] = args[argListIndex];
				}
				System.out.println("Search terms : " + Arrays.toString(searchTerms));
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
