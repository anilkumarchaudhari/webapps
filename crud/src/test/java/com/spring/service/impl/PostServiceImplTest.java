package com.spring.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PostServiceImplTest {

	
	@BeforeEach
	public void init() {
		System.out.println("init");
	}
    
	@BeforeAll
	public static void initAll() {
		System.out.println("initAll");
	}
	
	@Test
	@DisplayName("test case odd numbers")
	public void testOdd() {
		assertEquals(true, true);
	}
	
	@AfterEach
	public void clear() {
		System.out.println("after");
	}
	
	@AfterAll
	public static void clearAll() {
		System.out.println("afterAll");
	}
}
