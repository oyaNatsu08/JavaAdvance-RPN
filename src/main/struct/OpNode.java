package struct;

/**
 * 演算子ノードを表現するクラス。
 *
 * @author AxiZ
 *
 */
public class OpNode extends AbstractNode<String> {

    public OpNode(String op) {
        super(op);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.OPERATOR;
    }

}