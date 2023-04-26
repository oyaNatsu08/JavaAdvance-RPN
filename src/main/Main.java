import rpn.ReversePolishNotation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("計算式を入力してください：");
        var sc = new Scanner(System.in);
        var expr = sc.nextLine();

        ReversePolishNotation rpn = new ReversePolishNotation(expr);
        rpn.parse();

        System.out.println("中置記法：" + rpn.getExpr());
        System.out.println("逆ポーランド記法： " + rpn.getRpn());
        System.out.println("計算結果：" + rpn.getValue());
    }
}