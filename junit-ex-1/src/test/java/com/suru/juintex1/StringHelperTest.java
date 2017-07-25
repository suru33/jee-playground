package com.suru.juintex1;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {

	@Test // testing annotation
	public void testTuncate2APositionsFirst() { // test method should be public void
		StringHelper helper = new StringHelper();
		// assertEquals(expected, actual);
		assertEquals("CD", helper.tuncate2APositionsFirst("AACD")); // success
		assertEquals("ACS", helper.tuncate2APositionsFirst("AAACS")); // success
		assertEquals("CD", helper.tuncate2APositionsFirst("BACD")); // fail
	}

	@Test
	public void testFirstAndLastCharsAreSame_SimpleFalseTest() {
		StringHelper helper = new StringHelper();
		// check the return value is false or not
		assertFalse(helper.firstAndLastCharsAreSame("ASQUEII"));
	}

	@Test
	public void testFirstAndLastCharsAreSame_SimpleTrueTest() {
		StringHelper helper = new StringHelper();
		// check the return value is true or not
		assertTrue(helper.firstAndLastCharsAreSame("ZSBAZ"));
	}

}
