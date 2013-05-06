/**
 * 
 */
package de.hsrm.sem2.progtech.test.uebung02.testcases;

import org.junit.BeforeClass;
import de.hsrm.sem2.progtech.test.uebung01.testcases.AbstractIterableTest;
import de.hsrm.sem2.progtech.uebung02.Interleave;

import java.util.Arrays;
import java.util.Iterator;


/**
 * @author Joakim Reinert, Matr.Nr.: 375147
 *
 */
public class InterleaveTest extends AbstractIterableTest<Integer> {

  private static Iterable<Integer> one;
  private static Iterable<Integer> other;
  private static Iterable<Integer> reference;

  @BeforeClass
  public static void initializeTest() {
      one = Arrays.asList(new Integer[]{1,2,3,4,5,6});
      other = Arrays.asList(new Integer[]{7,8,9,10});
      reference = Arrays.asList(new Integer[]{1,7,2,8,3,9,4,10,5,6});
  }

  protected Iterable<Integer> getIterable() {
      return new Iterable<Integer>() {
          public Iterator<Integer> iterator() {
              return new Interleave<Integer>(one, other);
          }
      };
  }

  protected Class<Integer> getTypeClass() {
      return Integer.class;
  }

  protected Iterable<Integer> getReference() {
      return reference;
  }

}
