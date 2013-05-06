/**
 * 
 */
package de.hsrm.sem2.progtech.test.uebung02.testcases;

import static org.junit.Assert.*;

import de.hsrm.sem2.progtech.uebung02.RandomIterable;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;

/**
 * @author Joakim Reinert, Matr.Nr.: 375147
 *
 */
public class RandomTest {

  private static RandomIterable random;

  @BeforeClass
  public static void initialize() {
      random = new RandomIterable();
  }
  @Test
  public void testIfIsIterable() {
      assertTrue(random instanceof Iterable);
  }

  @Test
  public void testIterator() {
      assertTrue(random.iterator() instanceof Iterator);
  }

  @Test
  public void testIfIteratorsNextReturnsInteger() {
      assertTrue(random.iterator().next() instanceof Integer);
  }

  @Test
  public void testHasNext() {
      assertTrue(random.iterator().hasNext());
  }

  @Test
  public void testInfiniteNext() {
      Iterator<Integer> randomIterator = random.iterator();
      for (int i = 0; i < 1000000; i++) {
          randomIterator.next(); 
          assertTrue(randomIterator.hasNext());
      }
  }

}
