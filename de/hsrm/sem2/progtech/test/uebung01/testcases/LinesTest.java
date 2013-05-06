package de.hsrm.sem2.progtech.test.uebung01.testcases;

import java.util.Arrays;

import de.hsrm.sem2.progtech.uebung01.Lines;


public class LinesTest extends AbstractIterableTest<String> {

	private final String STRING = "Ein\nString\nÜber\nMehrere\nZeilen";
	@Override
	protected Iterable<String> getIterable() {
		return new Lines(STRING);
	}

	@Override
	protected Class<String> getTypeClass() {
		return String.class;
	}

	@Override
	protected Iterable<String> getReference() {
		return Arrays.asList(STRING.split("\n"));
	}


}
