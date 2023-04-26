package struct.traverse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import struct.IntegerNode;
import struct.Node;
import struct.OpNode;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TreeTraverseTest {

    private PrintStream _out;
    private ByteArrayOutputStream baos;

    @Before
    public void setUp() throws Exception {
        _out = System.out;

        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(_out);
    }

    @Test
    public void testPostOrder() {
        Node n1 = new OpNode("+");

        Node n2 = new IntegerNode(3);
        n1.setLeft(n2);

        Node n3 = new IntegerNode(5);
        n1.setRight(n3);

        Node n4 = new OpNode("*");
        n4.setLeft(n1);

        Node n5 = new IntegerNode(2);
        n4.setRight(n5);

        TreeTraverse.postOrder(n4, new PrintStrategy());

        assertEquals("3 5 + 2 * ", baos.toString());
    }

    private static class PrintStrategy implements NodeStrategy<Void> {

        @Override
        public void execute(Node node) {
            System.out.print(node.getValue() + " ");
        }

        @Override
        public Void getResult() {
            throw new UnsupportedOperationException();
        }

    }

}