package com.suru.juintex1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArrayCompareTest {

	@Test
	public void testArraySort_RandomArrayFail() {
		int[] numbers = { 12, 3, 5, 1, 10 };
		int[] expected = { 1, 3, 5, 10, 12 };
		Arrays.sort(numbers);

		// this is a fail test
		// JUnit compares the instances of both objects
		assertEquals(expected, numbers); // fail
	}

	@Test
	public void testArraySort_RandomArraySuccess() {
		int[] numbers = { 12, 3, 5, 1, 10 };
		int[] expected = { 1, 3, 5, 10, 12 };
		Arrays.sort(numbers);

		// success
		// for arrays we need to use assertArrayEquals
		assertArrayEquals(expected, numbers);
	}

	@Test
	public void testArraySort_RandomArrayFailResult() {
		int[] numbers = { 12, 3, 5, 1, 10 };
		int[] expected = { 10, 3, 5, 10, 12 };
		Arrays.sort(numbers);

		// fail with correct method usage
		// but output is wrong
		assertArrayEquals(expected, numbers);
	}
}
