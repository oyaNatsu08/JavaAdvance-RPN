import struct.IntegerNode;
import struct.Node;
import struct.OpNode;
import struct.traverse.ToStringStrategy;
import struct.traverse.TreeTraverse;

/**
 * {@code 数式 -> 二分木 -> 逆ポーランド記法} のサンプルです。
 *
 * @author AxiZ
 *
 */
public class ExprTreeSample {

    public static void main(String[] args) {
        /*
         * 例として 3*5+2 の数式を考える。              2+3*5
         * この数式は以下の二分木に展開される。
         *
         *     +                                    *
         *    / \
         *   *   2                              +       5
         *  / \
         * 3   5                               2  3
         *
         * これを帰りがけ順で列挙すると
         * 3 5 * 2 +
         * となり、これが元の数式を逆ポーランド記法にしたもの。
         */
        Node n1 = new OpNode("*");
        Node n2 = new IntegerNode(3);
        Node n3 = new IntegerNode(5);

        n1.setLeft(n2);
        n1.setRight(n3);

        Node n4 = new OpNode("+");
        Node n5 = new IntegerNode(2);

        n4.setLeft(n1);
        n4.setRight(n5);

        ToStringStrategy toStringStrategy = new ToStringStrategy();
        TreeTraverse.postOrder(n4, toStringStrategy);
        System.out.println(toStringStrategy.getResult());


        /*
         * 逆ポーランド記法で表された式は以下の手順で計算することができる。
         *
         * スタック | 逆ポーランド記法残り
         * []       | 3 5 * 2 +           <- 初期状態（空のスタックと逆ポーランド記法）
         * [3]      | 5 * 2 +             <- 先頭の3をスタックにpush
         * [3 5]    | * 2 +               <- 先頭の5をスタックにpush
         * [15]     | 2 +                 <- 先頭が演算子だったので、スタックからpopを2回して計算、計算結果を再度スタックにpush
         * [15 2]   | +                   <- 先頭の2をスタックにpush
         * [17]     |                     <- 先頭が演算子だったので、スタックからpopを2回して計算、計算結果を再度スタックにpush
         *
         * 逆ポーランド記法が空になったら計算終了。スタックには値が1つだけあるはずなので、これが計算結果となる。
         */
    }

}