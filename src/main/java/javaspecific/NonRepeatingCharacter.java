package main.java.javaspecific;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NonRepeatingCharacter {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter word to find first non-repeating character : ");
		String input = scanner.nextLine();
		scanner.close();
		
		final Map<Character, Integer> characterMap = getMapOfCharactersInString(input);
		final Character firstNonRepeatingValue = firstNonRepeating(input, characterMap);
		final int numberOfWordsInString = getNumberOfWordsInString(input);
		
		if (firstNonRepeatingValue != null) {
			System.out.println(String.format("The first non-repeating character is : %c", (firstNonRepeatingValue)));
		
		}
		else {
			System.out.println("Input contains no non-repeating characters");
		}
		
		System.out.println("Appearance of each char in your string : ");
		System.out.println(characterMap);
		
		System.out.println(String.format("Number of words in string : %d", numberOfWordsInString));
	}

	private static int getNumberOfWordsInString(String input) {
		String[] array = input.split(" ");
		return array.length;
	}
	
	private static Map<Character, Integer> getMapOfCharactersInString(String input) {
		Map<Character, Integer> characterMap = new HashMap<Character, Integer>();
		
		for (Character c : input.toCharArray()) {
			if (! characterMap.containsKey(c)) {
				characterMap.put(c, 1);
			}
			else {
				characterMap.compute(c, (k, v) -> v + 1);
			}
		}
		return characterMap;
	}
	
	private static Character firstNonRepeating(String input, Map<Character, Integer> characterMap) {
		Character firstNonRepeatingValue = null;
		for (Character c : input.toCharArray()) {
			if (characterMap.containsKey(c)) {
				if (characterMap.get(c) == 1) {
					firstNonRepeatingValue = c;
					break;
				}
			}
		}
		return firstNonRepeatingValue;
	}
}
