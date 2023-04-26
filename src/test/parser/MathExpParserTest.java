package parser;

import org.junit.Before;
import org.junit.Test;
import struct.traverse.NodeStrategy;
import struct.traverse.ToStringStrategy;
import struct.traverse.TreeTraverse;

import static org.junit.Assert.assertEquals;

public class MathExpParserTest {

    private MathExpParser mep;
    private NodeStrategy<String> strategy;

    @Before
    public void setUp() throws Exception {
        strategy = new ToStringStrategy();
    }

    @Test
    public void testMathExpParser1() {
        mep = new MathExpParser("1+2+3");
        TreeTraverse.postOrder(mep.parse(), strategy);

        assertEquals("1 2 + 3 +", strategy.getResult());
    }

    @Test
    public void testMathExpParser2() {
        mep = new MathExpParser("1+2*3");
        TreeTraverse.postOrder(mep.parse(), strategy);

        assertEquals("1 2 3 * +", strategy.getResult());
    }

    @Test
    public void testMathExpParser3() {
        mep = new MathExpParser("1*2+3");
        TreeTraverse.postOrder(mep.parse(), strategy);

        assertEquals("1 2 * 3 +", strategy.getResult());
    }

    @Test
    public void testMathExpParser4() {
        mep = new MathExpParser("1*2+3+4");
        TreeTraverse.postOrder(mep.parse(), strategy);

        assertEquals("1 2 * 3 + 4 +", strategy.getResult());
    }

    @Test
    public void testMathExpParser5() {
        mep = new MathExpParser("1+2*3*4");
        TreeTraverse.postOrder(mep.parse(), strategy);

        assertEquals("1 2 3 * 4 * +", strategy.getResult());
    }

    @Test
    public void testMathExpParser6() {
        mep = new MathExpParser("1*2+3*4");
        TreeTraverse.postOrder(mep.parse(), strategy);

        assertEquals("1 2 * 3 4 * +", strategy.getResult());
    }

//	/* ここからは応用課題 */
//	@Test
//	public void testMathExpParser7() {
//		mep = new MathExpParser("1*(2+3)*4");
//		TreeTraverse.postOrder(mep.parse(), strategy);
//
//		assertEquals("1 2 3 + * 4 *", strategy.getResult());
//	}
//
//	@Test
//	public void testMathExpParser8() {
//		mep = new MathExpParser("1*((2+3)*4)");
//		TreeTraverse.postOrder(mep.parse(), strategy);
//
//		assertEquals("1 2 3 + 4 * *", strategy.getResult());
//	}
//
//	@Test
//	public void testMathExpParser9() {
//		mep = new MathExpParser("10+20+30");
//		TreeTraverse.postOrder(mep.parse(), strategy);
//
//		assertEquals("10 20 + 30 +", strategy.getResult());
//	}

}