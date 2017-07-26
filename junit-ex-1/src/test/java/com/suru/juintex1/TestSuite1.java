package com.suru.juintex1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// to perform group test
@RunWith(Suite.class)
// test classes to be run
@SuiteClasses({ ExceptionTest.class, ParameterizedTest.class, QuickBeforeAndAfterTest.class })
public class TestSuite1 {

}
