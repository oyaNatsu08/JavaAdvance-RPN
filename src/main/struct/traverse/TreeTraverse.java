package struct.traverse;

import struct.Node;

/**
 * 木を走査するための処理を提供します。
 *
 * @author AxiZ
 *
 */
public class TreeTraverse {

    /**
     * インスタンス化を禁止します。
     */
    private TreeTraverse() {
    }

    /**
     * 指定されたノードを帰りがけ順で走査します。
     *
     * @param node 走査するノード
     * @param strategy 各ノードで実行する処理
     */
    public static void postOrder(Node node, NodeStrategy<?> strategy) {
        if (node.hasLeft()) {
            postOrder(node.getLeft(), strategy);
        }

        if (node.hasRight()) {
            postOrder(node.getRight(), strategy);
        }

        strategy.execute(node);
    }

}