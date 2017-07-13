package main.java.textsearch;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;

public class CallableListSearcher implements Callable<Map<Integer, String>> {

	private Map<Integer, String> strings;
	private String[] searchTerms;
	
	public CallableListSearcher(Map<Integer, String> strings, String[] searchTerms) {
		this.strings = strings;
		this.searchTerms = searchTerms;
	}
	
	@Override
	public Map<Integer, String> call() throws Exception {
		
		Iterator it = strings.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			String value = (String) pair.getValue();
			for (String term : searchTerms) {
				if (!value.toLowerCase().contains(term.toLowerCase())) {
					strings.get(pair.getKey());
				}
			}
			
		}
		
		return strings;
	}

}
