package main.java.general;

import java.math.BigInteger;
import java.util.ArrayList;

public class Fibonacci {

	public static BigInteger fibonacci(int num) {
		if (num == 1) {
			return BigInteger.valueOf(num);
		}
		else if (num == 0) {
			return BigInteger.ZERO;
		}
		else {
			return fibHelper(BigInteger.ZERO, BigInteger.valueOf(1), num);
		}
	}
	private static BigInteger fibHelper(BigInteger accumulator, BigInteger next, int count) {
		if (count <= 0) {
			return accumulator;
		}
		return fibHelper(next, accumulator.add(next), count - 1);
	}
	
	public static ArrayList<BigInteger> getListOfFibs(BigInteger num) {
		ArrayList<BigInteger> list = new ArrayList<>();
		int count = 0;
		
		while (list.size() < num.longValue()) {
			BigInteger currentFib = fibonacci(count);
			if (currentFib.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
				list.add(currentFib);
			}
			count++;
		}
		return list;
	}
	
	public static BigInteger sumOfList(ArrayList<BigInteger> list) {
		return list.parallelStream()
				   .reduce(BigInteger.ZERO, BigInteger::add);
	}
}