package struct;

/**
 * Nodeインターフェースの共通実装を提供します。
 *
 * @author AxiZ
 *
 * @param <E> ノードが保持する値の型
 */
public abstract class AbstractNode<E> implements Node {

    /** 左子ノード */
    protected Node left;
    /** 右子ノード */
    protected Node right;
    /** 保持する値 */
    protected E value;

    /**
     * 値を持たないノードインスタンスを生成します。
     */
    public AbstractNode() {
    }

    /**
     * 指定された値を保持したノードインスタンスを生成します。
     *
     * @param value ノードが保持する値
     */
    public AbstractNode(E value) {
        this.value = value;
    }

    @Override
    public boolean hasLeft() {
        return left != null;
    }

    @Override
    public boolean hasRight() {
        return right != null;
    }

    @Override
    public void setLeft(Node left) {
        this.left = left;
    }

    @Override
    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public Node getLeft() {
        return left;
    }

    @Override
    public Node getRight() {
        return right;
    }

    @Override
    public E getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue().toString();
    }

}