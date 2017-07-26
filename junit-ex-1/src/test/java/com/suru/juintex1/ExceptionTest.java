package com.suru.juintex1;

import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Test;

public class ExceptionTest {

	@Test
	public void testNullFail() {
		int[] numbers = null;
		// throws NullPointerException exception
		// test fail
		Arrays.sort(numbers);
		assertArrayEquals(numbers, numbers);
	}

	// expecting NullPointerException
	@Test(expected = NullPointerException.class)
	public void testNullSuccess() {
		int[] numbers = null;
		// throws NullPointerException exception
		// test pass expected type is NullPointerException
		Arrays.sort(numbers);
		assertArrayEquals(numbers, numbers);
	}
}
