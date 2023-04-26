package parser;

import struct.Node;

/**
 * 文字列で表現された中置記法の数式を二分木にパースする機能を提供するクラスです。
 *
 * @author AxiZ
 *
 */
public class MathExpParser {

    /** 中置記法の数式 */
    private String expr;

    /**
     * パース対象の数式を保持したインスタンスを生成します。
     *
     * @param expr 数式
     */
    public MathExpParser(String expr) {
        this.expr = expr;
    }

    /**
     * パース前の数式を返します。
     *
     * @return 数式
     */
    public String getExpr() {
        return expr;
    }

    /**
     * 数式を二分木にパースします。
     *
     * @return 二分木にパースされた数式
     */
    public Node parse() {
        // TODO: 実装対象
        return null;
    }

}