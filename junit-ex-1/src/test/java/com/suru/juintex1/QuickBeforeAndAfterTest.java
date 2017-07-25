package com.suru.juintex1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAndAfterTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("before class called");
	}

	// will execute before each test
	@Before
	public void setup() {
		System.out.println("before called");
	}

	@Test
	public void test1() {
		System.out.println("test-1 executed");
	}

	@Test
	public void test2() {
		System.out.println("test-2 executed");
	}

	// will execute after each test
	@After
	public void teardown() {
		System.out.println("after called");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("after class called");
	}
}
