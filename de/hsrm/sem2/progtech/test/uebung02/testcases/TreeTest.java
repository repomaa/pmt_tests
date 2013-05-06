/**
 * 
 */
package de.hsrm.sem2.progtech.test.uebung02.testcases;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import de.hsrm.sem2.progtech.uebung02.Tree;

/**
 * @author Joakim Reinert, Matr.Nr.: 375147
 *
 */
public class TreeTest {

    private Tree<String> root;
    private Tree<String> level2a;
    private Tree<String> level2b;
    private Tree<String> level3a;
    private Tree<String> level3b;
    private Tree<String> level3c;
    private Tree<String> level3d;
    private Tree<String> level4a;
    private Tree<String> level4b;
    private Tree<String> level4c;
    private Tree<String> level4d;
    private Tree<String> level4e;
    private Tree<String> level4f;
    private Tree<String> level4g;
    private Tree<String> level4h;
    private Tree<String> empty;

    @Before
    public void initialize() {
       level4a = new Tree<String>("level4a");
       level4b = new Tree<String>("level4b");
       level4c = new Tree<String>("level4c");
       level4d = new Tree<String>("level4d");
       level4e = new Tree<String>("level4e");
       level4f = new Tree<String>("level4f");
       level4g = new Tree<String>("level4g");
       level4h = new Tree<String>("level4h");
       level3a = new Tree<String>("level3a", level4a, level4b);
       level3b = new Tree<String>("level3b", level4c, level4d);
       level3c = new Tree<String>("level3c", level4e, level4f);
       level3d = new Tree<String>("level3d", level4g, level4h);
       level2a = new Tree<String>("level2a", level3a, level3b);
       level2b = new Tree<String>("level2b", level3c, level3d);
       root = new Tree<String>("root", level2a, level2b);
       empty = new Tree<String>();
    }

	  @Test
	  public void testSize() {
        assertEquals(15, root.size());
        assertEquals(1, level4a.size());
        assertEquals(7, level2a.size());
        assertEquals(1, empty.size());
	  }

    @Test
    public void testDepth() {
        assertEquals(root.depth(), 4);
        assertEquals(level2a.depth(), 3);
        assertEquals(level3a.depth(), 2);
        assertEquals(level4a.depth(), 1);
        assertEquals(empty.depth(), 0);
    }

    @Test
    public void testFringe() {
        String[] allLeafs = new String[] {
            level4a.getElement(),
            level4b.getElement(),
            level4c.getElement(),
            level4d.getElement(),
            level4e.getElement(),
            level4f.getElement(),
            level4g.getElement(),
            level4h.getElement(),
        };
        String[] leftSide = new String[4];
        System.arraycopy(allLeafs, 0, leftSide, 0, 4);
        assertArrayEquals(allLeafs, root.fringe().toArray());
        assertArrayEquals(leftSide, level2a.fringe().toArray());
    }

    @Test
    public void testPreorder() {
        String[] preorder = new String[] {
            root.getElement(),
            level2a.getElement(),
            level3a.getElement(),
            level4a.getElement(),
            level4b.getElement(),
            level3b.getElement(),
            level4c.getElement(),
            level4d.getElement(),
            level2b.getElement(),
            level3c.getElement(),
            level4e.getElement(),
            level4f.getElement(),
            level3d.getElement(),
            level4g.getElement(),
            level4h.getElement(),
        };
        assertArrayEquals(preorder, root.preorder().toArray());
    }

    @Test
    public void testPostorder() {
        String[] postorder = new String[] {
            level4a.getElement(),
            level4b.getElement(),
            level3a.getElement(),
            level4c.getElement(),
            level4d.getElement(),
            level3b.getElement(),
            level2a.getElement(),
            level4e.getElement(),
            level4f.getElement(),
            level3c.getElement(),
            level4g.getElement(),
            level4h.getElement(),
            level3d.getElement(),
            level2b.getElement(),
            root.getElement(),
        };
        assertArrayEquals(postorder, root.postorder().toArray());
    }

    @Test
    public void testPathTo() {
        String[] pathToLevel4f = new String[] {
            root.getElement(),
            level2b.getElement(),
            level3c.getElement(),
            level4f.getElement(),
        };
        assertArrayEquals(pathToLevel4f, root.pathTo("level4f").toArray());
    }

    @Test
    public void testIterable() {
        assertTrue(root.iterator() instanceof Iterator);
        String[] preorder = new String[15];
        root.preorder().toArray(preorder);
        List<String> iteratedElements = new ArrayList<String>();
        for(String currentElement : root)
            iteratedElements.add(currentElement);
        assertArrayEquals(preorder, iteratedElements.toArray());
    }

}
