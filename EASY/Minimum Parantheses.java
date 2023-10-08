QUESTION :- Minimum Parantheses 

Given a string s of parentheses ‘(‘ or ‘)’.

The task is to find the minimum number of parentheses ‘(‘ or ‘)’ (at any positions) we must add to make the resulting parentheses string valid.

A string is valid if:

Open brackets must be closed by the corresponding closing bracket.

Open brackets must be closed in the correct order.

Input Format
The first line given is a string s.

Output Format
Print a single integer denoting the minimum number of parentheses ‘(‘ or ‘)’ (at any positions) we must add in A to make the resulting parentheses string valid.

Example 1
Input

())
Output

1
Example 2
Input

(((
Output

3
Constraints
1 <= |s| <= 10^5
s[i] = '(' or s[i] = ')'


SOLUTION:-

import java.util.Scanner;
import java.util.Stack;

class Accio {
    static int MinimumParantheses(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty()) {
                stack.pop();
            } else {
                count++; // Invalid closing parenthesis
            }
        }

        return count + stack.size();
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Accio obj = new Accio();
        int ans = obj.MinimumParantheses(s);
        System.out.println(ans);
    }
}
