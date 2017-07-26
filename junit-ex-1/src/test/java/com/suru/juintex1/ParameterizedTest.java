package com.suru.juintex1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

// need to add to perform Parameterized Test
@RunWith(Parameterized.class)
public class ParameterizedTest {

	private StringHelper helper = new StringHelper();

	// input and expected output variables and a constructor
	private String input;
	private String expectedOutput;

	public ParameterizedTest(String input, String expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	// AACD -> CD
	// AAACS -> ACS

	// create a collection for input and expected output
	@Parameters
	public static Collection<String[]> testConditions() {
		// {<input>, <expected output>} collection
		String expected[][] = { { "AACD", "CD" }, { "AAACS", "ACS" } };
		return Arrays.asList(expected);
	}

	// only one test condition to run multiple parameters
	@Test
	public void testTuncate2APositionsFirst() {
		assertEquals(expectedOutput, helper.tuncate2APositionsFirst(input));
	}

}
