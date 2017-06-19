package test.java.javaspecific;

import static org.junit.Assert.assertEquals;

import java.nio.ByteBuffer;

import org.junit.Test;

import main.java.javaspecific.ByteReverser;

public class TestByteReverser {

	@Test
	public void testReverseEvenLengthByteArray() {
		byte[] bytes = new byte[4];
		ByteBuffer.wrap(bytes).putInt(0x04030201);
		
		ByteReverser.reverseBytes(bytes);
		
		int indexOneShouldBe = bytes[0];
		assertEquals(indexOneShouldBe, -2);
	}
	
	@Test
	public void testReverseOddLengthByteArray() {
		byte[] bytes = new byte[5];
		ByteBuffer.wrap(bytes).putInt(0x04030201);
		
		ByteReverser.reverseBytes(bytes);
		
		int indexFinalShouldBe = bytes[bytes.length - 1];
		assertEquals(indexFinalShouldBe, -5);
	}
}