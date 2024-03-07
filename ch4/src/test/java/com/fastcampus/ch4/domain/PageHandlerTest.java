package com.fastcampus.ch4.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class PageHandlerTest {

	@Test
	public void test() {
		PageHandler ph = new PageHandler(250, 1);
		ph.print();
		System.out.println("ph = " + ph);
		assertTrue(ph.startPage == 1);
		assertTrue(ph.endPage == 10);
	}
	
	@Test
	public void test2() {
		PageHandler ph = new PageHandler(250, 11);
		ph.print();
		System.out.println("ph = " + ph);
		assertTrue(ph.startPage == 11);
		assertTrue(ph.endPage == 20);
	}

	@Test
	public void test3() {
		PageHandler ph = new PageHandler(255, 25);
		ph.print();
		System.out.println("ph = " + ph);
		assertTrue(ph.startPage == 21);
		assertTrue(ph.endPage == 26);
	}
}
