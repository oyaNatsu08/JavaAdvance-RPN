package struct.traverse;

import struct.IntegerNode;
import struct.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ノードの値で四則演算を行います。
 * 帰りがけ順で走査する際にしか使えません。
 *
 * @author AxiZ
 *
 */
public class CalcStrategy implements NodeStrategy<Integer> {
    int result = 0;
    Stack<Integer> nums = new Stack<>();
    @Override
    public void execute(Node node) {
        // TODO: 実装対象

        if (node.getNodeType() == Node.NodeType.INTEGER) {
            nums.push(Integer.parseInt(node.getValue().toString()));
        } else if (node.getNodeType() == Node.NodeType.OPERATOR) {
            int num1 = nums.pop();
            int num2 = nums.pop();

            if ("+".equals(node.getValue())) {
                result = num1 + num2;
            } else if ("-".equals(node.getValue())) {
                result = num1 - num2;
            } else if ("*".equals(node.getValue())) {
                result = num1 * num2;
            } else if ("/".equals(node.getValue())) {
                result = num1 / num2;
            }

            //resultをスタックにプッシュ
            nums.push(result);
        }
    }

    @Override
    public Integer getResult() {
        // TODO: 実装対象
        return result;
    }

}