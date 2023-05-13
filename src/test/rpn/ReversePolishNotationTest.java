package rpn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReversePolishNotationTest {

    private ReversePolishNotation rpn;

    @Test
    public void testReversePolishNotation1() {
        rpn = new ReversePolishNotation("1+2+3");
        rpn.parse();

        assertEquals("1 2 + 3 +", rpn.getRpn());
        assertEquals(6, rpn.getValue());
    }

    @Test
    public void testReversePolishNotation2() {
        rpn = new ReversePolishNotation("1+2*3");
        rpn.parse();

        assertEquals("1 2 3 * +", rpn.getRpn());
        assertEquals(7, rpn.getValue());
    }

    @Test
    public void testReversePolishNotation3() {
        rpn = new ReversePolishNotation("1*2+3");
        rpn.parse();

        assertEquals("1 2 * 3 +", rpn.getRpn());
        assertEquals(5, rpn.getValue());
    }

    @Test
    public void testReversePolishNotation4() {
        rpn = new ReversePolishNotation("1*2+3+4");
        rpn.parse();

        assertEquals("1 2 * 3 + 4 +", rpn.getRpn());
        assertEquals(9, rpn.getValue());
    }

    @Test
    public void testReversePolishNotation5() {
        rpn = new ReversePolishNotation("1+2*3*4");
        rpn.parse();

        assertEquals("1 2 3 * 4 * +", rpn.getRpn());
        assertEquals(25, rpn.getValue());
    }

    @Test
    public void testReversePolishNotation6() {
        rpn = new ReversePolishNotation("1*2+3*4");
        rpn.parse();

        assertEquals("1 2 * 3 4 * +", rpn.getRpn());
        assertEquals(14, rpn.getValue());
    }

	/* ここからは応用課題 */
	@Test
	public void testReversePolishNotation7() {
		rpn = new ReversePolishNotation("1*(2+3)*4");
		rpn.parse();

		assertEquals("1 2 3 + * 4 *", rpn.getRpn());
		assertEquals(20, rpn.getValue());
	}

	@Test
	public void testReversePolishNotation8() {
		rpn = new ReversePolishNotation("1*((2+3)*4)");
		rpn.parse();

		assertEquals("1 2 3 + 4 * *", rpn.getRpn());
		assertEquals(20, rpn.getValue());
	}

	@Test
	public void testReversePolishNotation9() {
		rpn = new ReversePolishNotation("10+20+30");
		rpn.parse();

		assertEquals("10 20 + 30 +", rpn.getRpn());
		assertEquals(60, rpn.getValue());
	}

}