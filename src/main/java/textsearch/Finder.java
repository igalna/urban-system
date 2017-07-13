package main.java.textsearch;

import java.util.List;

public interface Finder {
	public List<Result> processInputFile(String fileName, String[] searchTerms);
}
