package kr.go.yeosu.test;

import org.junit.After;

import org.junit.Before;

import org.junit.Test;

public class Testcase0 {

	
	/*@BeforeClass
	public void beforeClass() {
		System.out.println("클래스 전");
	}*/
	
	@Before
	public void testBefore() {
		System.out.println("비포어");
	}
	
	@Test
	public void test1() {
		System.out.println("테스트 1");		
		//fail("Not yet implemented");
	}
	
	@Test
	public void test2() {
		System.out.println("테스트 2");		
		//fail("Not yet implemented");
	}
	
	@After
	public void testAfter() {
		System.out.println("애프터");
	}
	
	/*@AfterClass
	public void afterClass() {
		System.out.println("클래스 후");
	}*/
	
}
