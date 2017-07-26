package com.suru.juintex1;

import java.util.Arrays;

import org.junit.Test;

public class PerformaceTest {

	@Test(timeout = 10)
	public void testPerformance_Arrays() {

		// testing the performance of the code
		// throws TestTimedOutException when it take more time than expected time
		int array[] = { 10, 20, 30, 67, 1, 2, 0 };
		for (int i = 0; i < 1000000; i++) {
			array[i % array.length] = i;
			Arrays.sort(array);
		}
	}

}
