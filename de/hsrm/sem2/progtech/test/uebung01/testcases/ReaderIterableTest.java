package de.hsrm.sem2.progtech.test.uebung01.testcases;

import java.io.StringReader;

import de.hsrm.sem2.progtech.uebung01.ReaderIterable;


public class ReaderIterableTest extends CharIterableTest {
	
	@Override
	protected Iterable<Character> getIterable() {
		return new ReaderIterable(new StringReader(STRING));
	}
}
