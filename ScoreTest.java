package com.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void testGetScores() {
		Score s=new Score();
		assertEquals(s.getScores(""),0);
		assertEquals(s.getScores("hello"),8);
	}

}
