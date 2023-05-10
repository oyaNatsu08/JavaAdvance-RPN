package parser;

import struct.IntegerNode;
import struct.Node;
import struct.OpNode;
import struct.traverse.ToStringStrategy;
import struct.traverse.TreeTraverse;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

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
        //演算子を保持するスタック
        Deque<Character> stack = new ArrayDeque<>();
        //ノードにセットするためのリスト
        ArrayList<Node> listNode = new ArrayList<>();

        //優先順位を踏まえたうえで、リストに追加する
        for (int i = 0; i < expr.length(); i++) {
            //計算式を1文字ずつ受け取る
            Character c = expr.charAt(i);

            //もし文字が数字なら
            if (Character.isDigit(c)) {

                listNode.add(new IntegerNode(Integer.parseInt(c.toString())));

            } else if (c == '+' || c == '-') {      //演算子が + or - の時はどの演算子が来た場合でも優先順位で勝ることはないので、プッシュでスタックに保持

                //スタックの中に何かあり、かつ、スタックの中身が演算子なら、スタックの中身をポップして、リストに追加
                while (!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/')) {

                    listNode.add(new OpNode(stack.pop().toString()));

                }
                stack.push(c);

            } else if (c == '*' || c == '/') {      //演算子が * or / の場合は、スタックの中身が + や - の演算子はそのままスタックにプッシュ

                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {

                    listNode.add(new OpNode(stack.pop().toString()));

                }
                stack.push(c);

            }

        }

        //スタックの残りの中身を全てリストに追加
        while (!stack.isEmpty()) {
            listNode.add(new OpNode(stack.pop().toString()));
        }

        //System.out.println(listNode);
        int count = 0;
        while (listNode.size() > 1) {
            if (!listNode.get(count).toString().matches("[0-9]")) {
                //System.out.println(listNode.get(count) + " " + listNode.get(count-2) + " " + listNode.get(count-1));
                listNode.get(count).setLeft(listNode.get(count - 2));
                listNode.get(count).setRight(listNode.get(count - 1));

                listNode.remove(count - 1);
                listNode.remove(count - 2);

                count -= 2;
            }
            count++;
        }

        //System.out.println(listNode.get(0));

        ToStringStrategy toStringStrategy = new ToStringStrategy();
        TreeTraverse.postOrder(listNode.get(0), toStringStrategy);
        System.out.println(toStringStrategy.getResult());

        return listNode.get(0);

//        while (listNode.size() > 1) {
//            //演算子から1つ、数字から2つノードを受け取る
//            Node n1 = listNode.get(0);
//            Node n2 = listNode.get(1);
//            Node n3 = listNode.get(2);
//
//            listNode.remove(0);
//            listNode.remove(0);
//            listNode.remove(0);
//
//            //演算子のノードに数字をセット
//            n2.setLeft(n1);
//            n2.setRight(n3);
//
//            //演算子のノードをリストに追加
//            listNode.add(0, n2);
//        }

//        String[] strs = expr.split("");
//        ArrayList<Node> listNode = new ArrayList<>();
//        Stack<String> stack = new Stack<>();
//
//        //計算式を一文字ずつスタックに格納
//        for (String str : strs) {
//            if (str.matches("[0-9]")) {
//                listNode.add(new IntegerNode(Integer.parseInt(str)));
//            } else {
//                listNode.add(new OpNode(str));
//            }
//            //stack.push(str);
//        }

        //1+2+3、1*2+3の時
//        Node n1 = listNode.get(0);
//        Node n2 = listNode.get(1);
//        Node n3 = listNode.get(2);
//        Node n4 = listNode.get(3);
//        Node n5 = listNode.get(4);
//        n2.setLeft(n1);
//        n2.setRight(n3);
//        n4.setLeft(n2);
//        n4.setRight(n5);

        //1+2*3の時
//        Node n1 = listNode.get(0);
//        Node n2 = listNode.get(1);
//        Node n3 = listNode.get(2);
//        Node n4 = listNode.get(3);
//        Node n5 = listNode.get(4);
//        n4.setLeft(n3);
//        n4.setRight(n5);
//        n2.setLeft(n1);
//        n2.setRight(n4);

        //1*2+3+4の時
//        Node n1 = listNode.get(0);
//        Node n2 = listNode.get(0);
//        Node n3 = listNode.get(0);
//        Node n4 = listNode.get(0);
//        Node n5 = listNode.get(0);
//        Node n6 = listNode.get(0);
//        Node n7 = listNode.get(0);
//
//        n2.setLeft(n1);
//        n2.setRight(n3);
//        n4.setLeft(n2);
//        n4.setRight(n5);
//        n6.setLeft(n4);
//        n6.setRight(n7);


        //演算子の優先順位に合わせて、スタックの中身をリストに追加
//        while (!stack.isEmpty()) {
//            if ("*".equals(stack.get(stack.size()-1)) || "/".equals(stack.get(stack.size()-1))) {
//                listNode.add(0, new OpNode(stack.pop()));
//                listNode.add(0, new IntegerNode(Integer.parseInt(stack.pop())));
//                listNode.add(listNode.size(), new OpNode(stack.pop()));
//                listNode.add(listNode.size(), new IntegerNode(Integer.parseInt(stack.pop())));
//            } else if ("+".equals(stack.get(stack.size()-1)) || "-".equals(stack.get(stack.size()-1))) {
//                listNode.add(0, new OpNode(stack.pop()));
//                listNode.add(0, new IntegerNode(Integer.parseInt(stack.pop())));
//            } else {
//                listNode.add(0, new IntegerNode(Integer.parseInt(stack.pop())));
//            }
//        }

        //リストの並びの順にノードのセット処理
//        while (listNode.size() > 1) {
//            //演算子から1つ、数字から2つノードを受け取る
//            Node n1 = listNode.get(0);
//            Node n2 = listNode.get(1);
//            Node n3 = listNode.get(2);
//
//            listNode.remove(0);
//            listNode.remove(0);
//            listNode.remove(0);
//
//            //演算子のノードに数字をセット
//            n2.setLeft(n1);
//            n2.setRight(n3);
//
//            //演算子のノードをリストに追加
//            listNode.add(0, n2);
//        }

//        ToStringStrategy toStringStrategy = new ToStringStrategy();
//        TreeTraverse.postOrder(n6, toStringStrategy);
//        //System.out.println(toStringStrategy.getResult());
//
//        return n6;

//        String[] strs = expr.split("");
//        ArrayList<Node> listNum = new ArrayList<>();
//        Stack<Node> stackOp = new Stack<>();
//        ArrayList<Node> nodeResult = new ArrayList<>();
//
//        for (String str : strs) {
//            if (str.matches("[0-9]")) {
//                listNum.add(new IntegerNode(Integer.parseInt(str)));
//            } else {
//                if (stackOp.isEmpty()) {
//                   stackOp.push(new OpNode(str));
//                } else {
//                    Node tmp = stackOp.pop();
//                    if (("*".equals(str) || "/".equals(str)) && (!("*".equals(tmp.toString()) || "/".equals(tmp.toString())))) {
//                        stackOp.push(new OpNode(str));
//                    } else {
//                        stackOp.push(new OpNode(str));
//                        stackOp.push(tmp);
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < stackOp.size(); i++) {
//            if (i == 0) {
//                Node n1 = new OpNode(stackOp.pop().toString());
//                Node n2 = new IntegerNode(Integer.parseInt(listNum.get(0).toString()));
//                listNum.remove(0);
//                Node n3 = new IntegerNode(Integer.parseInt(listNum.get(0).toString()));
//                listNum.remove(0);
//
//                n1.setLeft(n2);
//                n1.setRight(n3);
//                nodeResult.add(n1);
//            } else {
//                Node n1 = new OpNode(stackOp.pop().toString());
//                Node n2 = new IntegerNode((Integer.parseInt(listNum.get(0).toString())));
//                listNum.remove(0);
//                n1.setLeft(nodeResult.get(i-1));
//                n1.setRight(n2);
//                nodeResult.add(n1);
//            }
//
//        }
//
//        ToStringStrategy toStringStrategy = new ToStringStrategy();
//        TreeTraverse.postOrder(nodeResult.get(nodeResult.size()-1), toStringStrategy);
//        System.out.println(toStringStrategy.getResult());
//
//        return nodeResult.get(nodeResult.size()-1);


//        Node n1 = new OpNode("+");
//        Node n2 = new IntegerNode(1);
//        Node n3 = new IntegerNode(2);
//
//        n1.setLeft(n2);
//        n1.setRight(n3);
//
//        Node n4 = new OpNode("*");
//        Node n5 = new IntegerNode(3);
//
//        n4.setLeft(n1);
//        n4.setRight(n5);
//
//        ToStringStrategy toStringStrategy = new ToStringStrategy();
//        TreeTraverse.postOrder(n4, toStringStrategy);
//        System.out.println(toStringStrategy.getResult());

    }

}