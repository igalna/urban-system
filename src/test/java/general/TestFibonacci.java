package test.java.general;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.Test;

import main.java.general.Fibonacci;

public class TestFibonacci {

	@Test
	public void testFibonacci() {
		long fib = Fibonacci.fibonacci(5).longValue();
		System.out.println(fib);
		assertEquals(5, fib);
	}

	@Test
	public void testGet100EvenFibs() {
		ArrayList<BigInteger> list = Fibonacci.getListOfFibs(BigInteger.valueOf(100));
		long firstEvenNumber = list.get(10).longValue();
		assertEquals(832040, firstEvenNumber);
	}
	
	@Test
	public void sumOfEvenFibs() {
		long sum = 44;
		ArrayList<BigInteger> anotherList = Fibonacci.getListOfFibs(BigInteger.valueOf(4));
		System.out.println(anotherList);
		long sumOfList = Fibonacci.sumOfList(anotherList).longValue();
		
		assertEquals(sum, sumOfList);
	}
	
	@Test
	public void testIterativeFibonacci() {
		int fib = Fibonacci.iterativeFibonacci(20);
		System.out.println("fibonacci with n=20 should be " + fib);
		assertEquals(6765, fib);
	}
}