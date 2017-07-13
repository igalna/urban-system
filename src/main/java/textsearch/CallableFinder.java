package main.java.textsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;

public class CallableFinder implements Finder {

	@Override
	public List<Result> processInputFile(String fileName, String[] searchTerms) {
		
		Map<Integer, String> id = new HashMap<>();
		Map<Integer, String> titles = new HashMap<>();
		Map<Integer, String> content = new HashMap<>();
		int count = 0;
		final int NTHREDS = 10;
		List<Result> results = new ArrayList<>();
		
		try (LineNumberReader lnr = new LineNumberReader(new FileReader(fileName))) {
			String string;
			
			while ((string = lnr.readLine()) != null) {
				String[] array = string.split(",");
				
				id.put(count, array[0]);
				titles.put(count, array[1]);
				content.put(count, array[2]);
				count++;
			}
			
			ExecutorService exec = Executors.newFixedThreadPool(NTHREDS);
			List<Future<Map<Integer, String>>> list = new ArrayList<>();
			
			Callable<Map<Integer, String>> worker0 = new CallableListSearcher(id, searchTerms);
			Future<Map<Integer, String>> future0 = exec.submit(worker0); 
			list.add(future0);
			
			Callable<Map<Integer, String>> worker1 = new CallableListSearcher(titles, searchTerms);
			Future<Map<Integer, String>> future1 = exec.submit(worker1);
			list.add(future1);
			
			Callable<Map<Integer, String>> worker2 = new CallableListSearcher(content, searchTerms);
			Future<Map<Integer, String>> future2 = exec.submit(worker2);
			list.add(future2);
			
			for (Future<Map<Integer, String>> future : list) {
				try {
					Map<Integer, String> burner = future.get();
					
					Iterator it = burner.entrySet().iterator();
					
					List<String> lines = FileUtils.readLines(new File(fileName));
					
					while (it.hasNext()) {
						Map.Entry pair = (Map.Entry) it.next();
						String line = lines.get((int) pair.getKey());
						String[] split = line.split(",");
						results.add(new Result(split[0], split[1]));
					}
					
					exec.shutdown();
					
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return results;
	}

}
