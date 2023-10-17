QUESTION :- Postfix Evaluation And Conversions 

You are given a postfix expression.

You are required to evaluate it and print its value. You are also required to convert it to infix and prefix print both of them.

Note

Use brackets in infix expressions to indicate precedence. For a better understanding, check the example.

Input Format
The first line contains a string s, denoting the postfix expression.

Output Format
In the first line of Output print, the answer is evaluated.

In the second line, print the infix expression.

In the last line, print the prefix expression.

Example 1
Input

264*8/+3-
Output

2
((2+((6*4)/8))-3)
-+2/*6483
Explanation

The evaluated expression is printed in the first line.

The postfix to the infix expression is printed in the second line.

The postfix to prefix expression is printed in the third line.

Example 2
Input

12+34*5/6*7/+
Output

4
((1+2)+((((3*4)/5)*6)/7))
++12/*/*34567
Explanation

The evaluated expression is printed in the first line.

The postfix to the infix expression is printed in the second line.

The postfix to prefix expression is printed in the third line.

Constraints
Expression is a valid prefix expression

The only operators used are +, -, *, /

All operands are single-digit numbers.


import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        evaluateExpression(str);
    }

    public static void evaluateExpression(String str) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<String> infixStack = new Stack<>();
        Stack<String> prefixStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                operandStack.push(ch - '0');
                infixStack.push(String.valueOf(ch));
                prefixStack.push(String.valueOf(ch));
            } else {
                String operand2 = String.valueOf(operandStack.pop());
                String operand1 = String.valueOf(operandStack.pop());
                operandStack.push(performOperation(operand1, operand2, ch));

                String infixOperand2 = infixStack.pop();
                String infixOperand1 = infixStack.pop();
                String infixResult = "(" + infixOperand1 + ch + infixOperand2 + ")";
                infixStack.push(infixResult);

                String prefixOperand2 = prefixStack.pop();
                String prefixOperand1 = prefixStack.pop();
                String prefixResult = ch + prefixOperand1 + prefixOperand2;
                prefixStack.push(prefixResult);
            }
        }

        int finalResult = operandStack.pop();
        String infixExpression = infixStack.pop();
        String prefixExpression = prefixStack.pop();

        System.out.println(finalResult);
        System.out.println(infixExpression);
        System.out.println(prefixExpression);
    }

    public static int performOperation(String operand1, String operand2, char operator) {
        int op1 = Integer.parseInt(operand1);
        int op2 = Integer.parseInt(operand2);
        switch (operator) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                return op1 / op2;
            default:
                return 0;
        }
    }
}

