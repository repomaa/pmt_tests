package de.hsrm.sem2.progtech.test.uebung01.testcases;

import java.util.ArrayList;
import java.util.Arrays;

import de.hsrm.sem2.progtech.uebung01.DiagonalIterable;
import de.hsrm.sem2.progtech.uebung01.Pair;



public class DiagonalIterableTest extends PairIterableTest {

	private Iterable<Integer> a;
	private Iterable<Integer> b;

	@Override
	protected Iterable<Pair<Integer, Integer>> getIterable() {
		a = Arrays.asList(new Integer[]{1,2,3,4,5});
		b = Arrays.asList(new Integer[]{8,9,10,11,12});
		return new DiagonalIterable<Integer, Integer>(a, b);
	}

	@Override
	protected Iterable<Pair<Integer, Integer>> getReference() {
		ArrayList<Pair<Integer, Integer>> ref = new ArrayList<Pair<Integer, Integer>>();
		for (Integer intA : this.a)
			for (Integer intB : this.b)
				ref.add(new Pair<Integer,Integer>(intA, intB));
		return ref;
	}

}
