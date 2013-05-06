package de.hsrm.sem2.progtech.test.uebung01.testcases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public abstract class AbstractIterableTest<T> {

	protected Iterable<T> iter;
	protected Class<T> cls;
	protected Iterable<T> ref;
	
	/**
	 * Used to obtain the Iterable which is tested
	 * @return the Iterable<T> object which will be tested
	 */
	protected abstract Iterable<T> getIterable();
	
	/**
	 * Used to obtain the Class of the Type of Iterable for this
	 * test case. This is needed, because Generic definitions
	 * are not available on runtime.
	 * @return the Class of the Type of Iterable
	 */
	protected abstract Class<T> getTypeClass();
	
	/**
	 * Used to obtain a reference Iterable object known to work
	 * correctly.
	 * @return a reference Iterable object of type T
	 */
	protected abstract Iterable<T> getReference();
	
	/**
	 * Initializes instance variables with the Iterable to be
	 * tested, the Class of the Type of the Iterable and a
	 * reference Iterable. This is run before each test.
	 */
	@Before
	public void initialize() {
		this.iter = getIterable();
		this.cls = getTypeClass();
		this.ref = getReference();
	}
	
	/**
	 * Tests whether the Iterable returns an Iterator for the
	 * iterator() method
	 */
	@Test
	public void testIterator() {
		assertTrue("iterator() doesn't return an Iterator", iter.iterator() instanceof Iterator);
	}
	
	/**
	 * Tests whether the Iterator has a next element.
	 */
	@Test
	public void testHasNext() {
		Iterator<T> chiterator = iter.iterator();
		assertTrue("hasNext() doesn't return true", chiterator.hasNext());
	}
	
	/**
	 * Tests whether the next() method of the Iterator returns
	 * an object with the correct type
	 */
	@Test
	public void testNext() {
		Iterator<T> chiterator = iter.iterator();
		assertTrue("next() doesn't return a correct type" , chiterator.next().getClass().isAssignableFrom(cls));
	}
	
	/**
	 * Tests the integrity of the Iterator by checking if the
	 * correct objects are returned by the next() method until
	 * hasNext() is false.
	 */
	@Test
	public void testIntegrity() {
		Collection<T> col = new HashSet<T>();
		for(T current:iter) {
			col.add(current);
		}
		Collection<T> refCol = new HashSet<T>();
		for(T current: ref) {
			assertTrue("The Object " + current.toString() + " wasn't returned by next()", col.contains(current));
			refCol.add(current);
		}
		assertEquals("The amount of objects returned by all next() calls is wrong", refCol.size(), col.size());
	}
	
	/**
	 * Tests if the order of the Iterator is correct.
	 * <h3>Note:</h3>
	 * Strictly speaking an Iterator is not required to return
	 * objects in any given order. Still it makes sense to
	 * implement iterators for ordered objects like Strings,
	 * Streams and the like so that the order is maintained.
	 */
	@Test
	public void testOrder() {
		List<T> list = new ArrayList<T>();
		for(T current:iter) {
			list.add(current);
		}
		Iterator<T> it = ref.iterator();
		for(int i = 0; i < list.size(); i++) {
			assertEquals("The element at index " + i + " is other than expected",
				it.next(), list.get(i));	
		}
	}

}
