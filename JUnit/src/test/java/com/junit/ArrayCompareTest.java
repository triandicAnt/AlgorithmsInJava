package com.junit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArrayCompareTest {

	@Test
	public void test() {
		int [] a = {1,3,2,5,4};
		int []e = {1,2,3,4,5};
		Arrays.sort(a);
		assertArrayEquals(e, a);
	}

}
