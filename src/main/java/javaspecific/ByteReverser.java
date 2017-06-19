package main.java.javaspecific;

public class ByteReverser {

	public static void reverseBytes(byte[] bytes) {
		
		int length = bytes.length - 1;
		
		for (int x = 0; x <= (bytes.length - 1) / 2; x ++) {
			byte temp = (byte) ~bytes[x];
			bytes[x] = (byte) ~bytes[length];
			bytes[length] = temp;
			length--;
		}
	}	
}