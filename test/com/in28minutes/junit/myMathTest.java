package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class myMathTest {
    private myMath math= new myMath();

    @BeforeAll
    static void beforeAll() {
		System.out.println("dummy tests");
    	System.out.println("before All");
    }
    
    @BeforeEach
    void beforeEach() {
    	System.out.println("before each");
    }
    
	@Test
	void Test1() {
		System.out.println("test1");
		}
	
	@Test
	void Test2() {
		System.out.println("test2");
		}

	@AfterEach
    void afterEach() {
    	System.out.println("after each");
    }
	@AfterAll
    static void afterAll() {
    	System.out.println("after All");
    }
}
