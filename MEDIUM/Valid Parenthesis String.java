QUESTION :- Valid Parenthesis String 


Given a string s containing only three types of characters: '(', ')' and '*', print true if s is valid.

The following rules define a valid string:
Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

Input Format
First line contains a single integer n(length of string).
Second line contains the string s of size n.

Output Format
Print true if the given string is valid else print false.

Example 1
Input

2
()
Output

true
Example 2
Input

4
((*)
Output

true
Explanation

Here '*' will treat as ')' , so output is true.

Constraints
1 <= s.length <= 100
s[i] is '(', ')' or '*'.

SOLUTION:-

import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static boolean checkValidString(int n, String s) {
        // Create two stacks: one for tracking open parentheses and another for asterisks.
        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> asteriskStack = new Stack<>();

        // Loop through the characters in the string.
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openStack.push(i);
            } else if (c == '*') {
                asteriskStack.push(i);
            } else {
                // If we encounter a closing parenthesis and there is a matching open parenthesis,
                // pop the open parenthesis from the stack.
                if (!openStack.isEmpty()) {
                    openStack.pop();
                }
                // If there is no open parenthesis, but we have an asterisk, pop it.
                // Asterisk can act as a closing parenthesis.
                else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    // If neither an open parenthesis nor an asterisk is available to match,
                    // return false as the string is not valid.
                    return false;
                }
            }
        }

        // Now, we have processed all the open and close parentheses.
        // Check if there are any remaining asterisks that can match the open parentheses.
        while (!openStack.isEmpty() && !asteriskStack.isEmpty()) {
            int openIndex = openStack.pop();
            int asteriskIndex = asteriskStack.pop();
            if (openIndex > asteriskIndex) {
                // If the asterisk appears before the open parenthesis, it can't match.
                return false;
            }
        }

        // If there are no open parentheses left, the string is valid.
        return openStack.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        Solution obj = new Solution();
        boolean ans = obj.checkValidString(n, s);
        if (ans) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}



