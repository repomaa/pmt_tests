package de.hsrm.sem2.progtech.test.uebung01.testcases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import de.hsrm.sem2.progtech.uebung01.Pair;
import de.hsrm.sem2.progtech.uebung01.PairIterable;


public class PairIterableTest extends AbstractIterableTest<Pair<Integer,Integer>> {

	private Iterable<Integer> a;
	private Iterable<Integer> b;
	@Override
	protected Iterable<Pair<Integer, Integer>> getIterable() {
		a = Arrays.asList(new Integer[]{1,2,3,4,5,6,7});
		b = Arrays.asList(new Integer[]{8,9,10,11,12});
		return new PairIterable<Integer, Integer>(a, b);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Class<Pair<Integer, Integer>> getTypeClass() {
		Pair<Integer, Integer> pair = new Pair<Integer, Integer>(1,1);
		return (Class<Pair<Integer, Integer>>) pair.getClass();
	}

	@Override
	protected Iterable<Pair<Integer, Integer>> getReference() {
		ArrayList<Pair<Integer, Integer>> ref = new ArrayList<Pair<Integer, Integer>>();
		ref.add(new Pair<Integer, Integer>(1,8));
		ref.add(new Pair<Integer, Integer>(2,9));
		ref.add(new Pair<Integer, Integer>(3,10));
		ref.add(new Pair<Integer, Integer>(4,11));
		ref.add(new Pair<Integer, Integer>(5,12));
		return ref;
	}
	
	/**
	 * Pair must implement the equals() method for other
	 * tests to pass, so it is tested here.
	 */
	@Test
	public void testPairEquals() {
		assertEquals("The Pair <1,1> doesn't equal another Pair <1,1>, please implement the equals method in Pair",
				new Pair<Integer, Integer>(1,1), new Pair<Integer, Integer>(1,1));
	}
	/**
	 * Pair must implement he hashCode() method for other
	 * tests to pass, so it is tested here.
	 */
	@Test
	public void testPairHashCodeEquals() {
		assertEquals("Equal Pairs don't have equal hashCodes, please implement hashCode",
				new Pair<Integer, Integer>(1,1).hashCode(),
				new Pair<Integer, Integer>(1,1).hashCode()); 
	}


}
