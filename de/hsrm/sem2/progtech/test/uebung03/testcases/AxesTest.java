/**
 * 
 */
package de.hsrm.sem2.progtech.test.uebung03.testcases;

import de.hsrm.sem2.progtech.uebung03.Axes;

import static org.junit.Assert.*;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

import java.io.InputStream;
import java.util.List;

import org.junit.Test;
import org.junit.Before;


/**
 * @author Joakim Reinert, Matr.Nr.: 375147
 *
 */
public class AxesTest {

    private Node root;
    private Node doc;

    public final String TEST_FILE_PATH = "../resources/beispiel.xml";

    @Before
    public void setUpRootNodeFromTestFile() throws Exception {
        doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(getTestFileStream());
        root = doc.getFirstChild();
    }

    public InputStream getTestFileStream() {
        return AxesTest.class.getResourceAsStream(TEST_FILE_PATH);
    }

    @Test
    public void testDescendantOrSelf() {
        String[] expected = new String[] {"A", "B", "C", "D1",
            "D2", "D3", "E1", "E2",
            "E3", "F1", "G1", "G2",
            "F2", "F3", "G3", "G4",
            "E4", "E5", "D4", "D5" };
        String[] actual = getNodeNames(Axes.descendantOrSelf(root));
        assertArrayEquals(expected, actual);      
    }

    @Test
    public void testParent() {
        String[] expected = new String[]{ "A" };
        String[] actual = getNodeNames(Axes.parent(Axes.child(root).get(0)));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAncestor() {
        String[] expected = new String[]{ "B", "A", doc.getNodeName() };
        String[] actual = getNodeNames(Axes.ancestor(Axes.findFirst("C", Axes.descendant(root))));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAncestorOrSelf() {
        String[] expected = new String[]{ "C", "B", "A", doc.getNodeName() };
        String[] actual = getNodeNames(Axes.ancestorOrSelf(Axes.findFirst("C", Axes.descendant(root))));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFollowingSibling() {
        String[] expected = new String[]{ "D4" };
        String[] actual = getNodeNames(Axes.followingSibling(Axes.findFirst("D3", Axes.descendant(root))));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testPrecedingSibling() {
        String[] expected = new String[]{ "D2" };
        String[] actual = getNodeNames(Axes.precedingSibling(Axes.findFirst("D3", Axes.descendant(root))));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFollowing() {
        String[] expected = new String[]{ "D4", "D5" };
        String[] actual = getNodeNames(Axes.following(Axes.findFirst("D3", Axes.descendant(root))));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testPreceding() {
        String[] expected = new String[]{ "D2", "D1" };
        String[] actual = getNodeNames(Axes.preceding(Axes.findFirst("D3", Axes.descendant(root))));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAttribute() {
        String[] expected = new String[] { "some_attribute", "some_other_attribute" };
        String[] actual = getNodeNames(Axes.attribute(root));
        for (String name: actual)
            System.out.print(name + ", ");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testNamespace() {
        String[] expected = new String[] { "http://some.other.example.org" };
        String[] actual = getNodeValues(Axes.namespace(Axes.findFirst("B", Axes.descendant(root))));
        assertArrayEquals(expected, actual);
    }

    private String[] getNodeNames(List<Node> nodes) {
        String[] result = new String[nodes.size()];
        for(int i = 0; i < nodes.size(); i++)
            result[i] = nodes.get(i).getNodeName();
        return result;
    }

    private String[] getNodeValues(List<Node> nodes) {
        String[] result = new String[nodes.size()];
        for(int i = 0; i < nodes.size(); i++)
            result[i] = nodes.get(i).getNodeValue();
        return result;
    }

}
