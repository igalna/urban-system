package test.java.general;

import org.junit.Test;

import main.java.general.ValueBase;

public class TestValueBase {

	@Test
	public void testgetValueInBase() {
		String value = "36";
		int originalBase = 10;
		int convertToBase = 16;
		
		String valueFromOriginalBaseToBase = ValueBase.getValueInBase(value, convertToBase, originalBase);
		
		assert(valueFromOriginalBaseToBase.equals("24"));
	}
	
	@Test
	public void testgetValueInAnotherBase() {
		String value = "7";
		int originalBase = 10;
		int convertToBase = 2;
		
		String valueFromOriginalBaseToBase = ValueBase.getValueInBase(value, convertToBase, originalBase);
		
		System.out.println(valueFromOriginalBaseToBase);
		assert(valueFromOriginalBaseToBase.equals("111"));
	}
	
	@Test
	public void testConvertFromBaseSixteenToBaseTen() {
		String value = "af";
		int originalBase = 16;
		int convertToBase = 10;
		
		String valueFromOriginalBaseToBase = ValueBase.getValueInBase(value, convertToBase, originalBase);
		
		System.out.println(valueFromOriginalBaseToBase);
		assert(valueFromOriginalBaseToBase.equals("175"));
	}
}