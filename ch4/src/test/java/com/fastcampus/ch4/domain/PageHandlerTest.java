package com.fastcampus.ch4.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class PageHandlerTest {

	@Test
	public void test() {
		PageHandler ph = new PageHandler(250, 1);
		ph.print();
		System.out.println("ph = " + ph);
		assertTrue(ph.getStartPage() == 1);
		assertTrue(ph.getEndPage() == 10);
	}
	
	@Test
	public void test2() {
		PageHandler ph = new PageHandler(250, 11);
		ph.print();
		System.out.println("ph = " + ph);
		assertTrue(ph.getStartPage() == 11);
		assertTrue(ph.getEndPage() == 20);
	}

	@Test
	public void test3() {
		PageHandler ph = new PageHandler(255, 25);
		ph.print();
		System.out.println("ph = " + ph);
		assertTrue(ph.getStartPage() == 21);
		assertTrue(ph.getEndPage() == 26);
	}
}
