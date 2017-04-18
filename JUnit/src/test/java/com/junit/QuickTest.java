package com.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickTest {

	@Before
	public void setup() {
		System.out.println("Before");
	}
	@BeforeClass
	public static void beforeClass(){
		System.out.println("Before class");
	}
	@Test
	public void test1() {
		System.out.println("Test 1");
	}
	@Test
	public void test2() {
		System.out.println("Test 2");

	}
	@After
	public void cleanup(){
		System.out.println("Cleaning up");
	}
	@AfterClass
	public static void  afterClass(){
		System.out.println("after class");
	}
}
