package main.java.general;

public class ValueBase {

	public static String getValueInBase(String value, int baseToConvertTo, int originalBase) {
		return Integer.toString(Integer.parseInt(value, originalBase), baseToConvertTo);
	}	
}