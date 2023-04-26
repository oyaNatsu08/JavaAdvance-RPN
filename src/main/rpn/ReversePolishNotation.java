package rpn;

import parser.MathExpParser;
import struct.Node;
import struct.traverse.CalcStrategy;
import struct.traverse.ToStringStrategy;
import struct.traverse.TreeTraverse;

/**
 * 中置記法の数式を逆ポーランド記法に変換し、計算を行うクラスです。
 *
 * @author AxiZ
 *
 */
public class ReversePolishNotation {

    /** 中置記法の数式 */
    private String expr;
    /** 逆ポーランド記法の数式 */
    private String rpn;
    /** 二分木で表現された数式 */
    private Node exprTree;
    /** 計算結果のキャッシュ */
    private Integer cache;

    /**
     * 中置記法の数式を保持するインスタンスを生成します。
     *
     * @param expr 数式
     */
    public ReversePolishNotation(String expr) {
        this.expr = expr;
    }

    /**
     * 中置記法の数式をパースします。
     */
    public void parse() {
        if (exprTree != null) {
            return;
        }
        MathExpParser mep = new MathExpParser(expr);
        exprTree = mep.parse();
    }

    /**
     * 中置記法の数式を取得します。
     *
     * @return 中置記法の数式
     */
    public String getExpr() {
        return expr;
    }

    /**
     * 逆ポーランド記法の数式を取得します。
     *
     * @return 逆ポーランド記法の数式
     */
    public String getRpn() {
        if (exprTree == null) {
            throw new IllegalStateException();
        }
        if (rpn != null) {
            return rpn;
        }

        ToStringStrategy toStringStrategy = new ToStringStrategy();
        TreeTraverse.postOrder(exprTree, toStringStrategy);
        rpn = toStringStrategy.getResult();
        return rpn;
    }

    /**
     * 計算結果を取得します。
     *
     * @return 計算結果
     */
    public int getValue() {
        if (exprTree == null) {
            throw new IllegalStateException();
        }
        if (cache != null) {
            return cache;
        }

        CalcStrategy calcStrategy = new CalcStrategy();
        TreeTraverse.postOrder(exprTree, calcStrategy);
        cache = calcStrategy.getResult();
        return cache;
    }

}