package struct;

/**
 * 整数ノードを表現するクラス。
 *
 * @author AxiZ
 *
 */
public class IntegerNode extends AbstractNode<Integer> {

    public IntegerNode(Integer value) {
        super(value);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.INTEGER;
    }

}