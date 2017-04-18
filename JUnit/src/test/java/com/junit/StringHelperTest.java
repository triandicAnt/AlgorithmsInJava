package com.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {

	@Test
	public void testTruncateAInFirst2Positions() {
		assertEquals(new StringHelper().truncateAInFirst2Positions("AACD"), "CD");
	}
	@Test
	public void test2(){
		assertEquals("XY", "AB");
	}

}
