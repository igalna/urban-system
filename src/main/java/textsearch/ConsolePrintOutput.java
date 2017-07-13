package main.java.textsearch;

import java.util.List;

public class ConsolePrintOutput implements ResultOutput {

	@Override
	public void output(List<Result> results) {
		for (Result r : results) {
			System.out.println("ID : " + r.getId() + " Title : " + r.getTitle());
		}
	}

}
