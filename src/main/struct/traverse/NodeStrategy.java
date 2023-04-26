package struct.traverse;

import struct.Node;

/**
 * 木を走査する際に各ノードで実行する処理を提供します。
 * 全てのノードを走査し終わった結果は{@link #getResult()}で取得します。
 *
 * @author AxiZ
 *
 * @param <T> 処理結果の型
 */
public interface NodeStrategy<T> {

    /**
     * 各ノードで実行される処理です。
     *
     * @param node ノード
     */
    public void execute(Node node);

    /**
     * 走査後の結果を取得します。
     *
     * @return 結果
     */
    public T getResult();

}