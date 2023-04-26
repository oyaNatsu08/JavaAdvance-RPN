package struct;

/**
 * 二分木のノードを表すインターフェース。
 *
 * @author AxiZ
 *
 */
public interface Node {

    /**
     * このノードのタイプを返します。
     *
     * @return ノードタイプ
     * @see NodeType
     */
    public NodeType getNodeType();

    /**
     * 左子ノードを持っているかを返します。
     *
     * @return 左子ノードを持っていればtrue
     */
    public boolean hasLeft();

    /**
     * 右子ノードを持っているかを返します。
     *
     * @return 右子ノードを持っていればtrue
     */
    public boolean hasRight();

    /**
     * 左子ノードとしてノードをセットします。
     *
     * @param left 左子ノード
     */
    public void setLeft(Node left);

    /**
     * 右子ノードとしてノードをセットします。
     *
     * @param right 右子ノード
     */
    public void setRight(Node right);

    /**
     * 左子ノードを取得します。
     *
     * @return 左子ノード
     */
    public Node getLeft();

    /**
     * 右子ノードを取得します。
     *
     * @return 右子ノード
     */
    public Node getRight();

    /**
     * このノードが保持している値を取得します。
     *
     * @return このノードが保持している値
     */
    public Object getValue();

    /**
     * ノードタイプを表す列挙型。
     *
     * @author AxiZ
     *
     */
    public static enum NodeType {
        /** 演算子ノード */
        OPERATOR,
        /** 整数ノード */
        INTEGER;
    }

}