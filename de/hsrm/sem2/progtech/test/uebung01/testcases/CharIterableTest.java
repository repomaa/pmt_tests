package de.hsrm.sem2.progtech.test.uebung01.testcases;

import java.util.ArrayList;

import de.hsrm.sem2.progtech.uebung01.CharIterable;


public class CharIterableTest extends AbstractIterableTest<Character> {
	
	protected final String STRING = "ein string";

	@Override
	protected Iterable<Character> getIterable() {
		return new CharIterable(STRING);
	}

	@Override
	protected Class<Character> getTypeClass() {
		return Character.class;
	}

	@Override
	protected Iterable<Character> getReference() {
		ArrayList<Character> result = new ArrayList<Character>();
		for(char cur:STRING.toCharArray())
			result.add(new Character(cur));
		return result;
	}

}
