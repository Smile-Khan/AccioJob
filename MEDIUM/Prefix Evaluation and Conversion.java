QUESTION :- Prefix Evaluation and Conversion 

You are given a prefix expression.

You are required to evaluate it and print it's value.

You are required to convert it to infix and print it.

You are required to convert it to postfix and print it.

Note

Use brackets in infix expression for indicating precedence. Check sample input output for more details.

Input Format
The first line of input contains a string str, prefix expression.

Output Format
You need to output 3 lines,

The value of the expression.

It's infix expression.

It's postfix expression.

Example 1
Input

-+2/*6483
Output

2
((2+((6*4)/8))-3)
264*8/+3-
Explanation

The value for the given prefix expression is 2, its infix expression is ((2+((64)/8))-3) and its postfix expression is 2648/+3-.

Example 2
Input

++123
Output

6
((1+2)+3)
12+3+
Explanation

The given string ab has 2 permutations ab and ba.

Constraints
Expression is a valid prefix expression

The only operators used are +, -, *, /

All operands are single digit numbers.


SOLUTION :-

import java.util.Stack;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        evaluateExpression(str);
    }

    public static void evaluateExpression(String str) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<String> infixStack = new Stack<>();
        Stack<String> postfixStack = new Stack<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                operandStack.push(ch - '0');
                infixStack.push(String.valueOf(ch));
                postfixStack.push(String.valueOf(ch));
            } else {
                String operand1 = postfixStack.pop();
                String operand2 = postfixStack.pop();
                String result = operand1 + operand2 + ch;

                postfixStack.push(result);

                int value1 = operandStack.pop();
                int value2 = operandStack.pop();
                int resultValue = performOperation(value1, value2, ch);
                operandStack.push(resultValue);

                String infixOperand1 = infixStack.pop();
                String infixOperand2 = infixStack.pop();
                String infixResult = "(" + infixOperand1 + ch + infixOperand2 + ")";
                infixStack.push(infixResult);
            }
        }

        int finalResult = operandStack.pop();

        String infixExpression = infixStack.pop();
        String postfixExpression = postfixStack.pop();

        System.out.println(finalResult);
        System.out.println(infixExpression);
        System.out.println(postfixExpression);
    }

    public static int performOperation(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                return 0;
        }
    }
}

