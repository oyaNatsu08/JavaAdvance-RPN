package struct.traverse;

import struct.Node;

/**
 * 各ノードの値をスペース区切りの文字列として結合します。
 *
 * @author AxiZ
 *
 */
public class ToStringStrategy implements NodeStrategy<String> {

    private StringBuilder sb = new StringBuilder();

    @Override
    public void execute(Node node) {
        sb.append(node.getValue() + " ");
    }

    @Override
    public String getResult() {
        return sb.toString().trim();
    }

}
