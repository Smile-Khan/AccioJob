QUESTION :- Reverse Substrings Between Each Pair of Parentheses 


You are given a string s that consists of lower case alphabets and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Result should be bracket-less.

Input Format
Input consists of a single string s

Output Format
Print the new string after formatting

Example 1
Input

(abcd)
Output

dcba
Explanation

There is a single pair of brackets in this string and the substring in between them, abcd gets reversed to dcba and parantheses gets removed.

Example 2
Input

(accio(job))
Output

joboicca
Explanation

The substring "job" is reversed first, then the whole string is reversed.

Constraints
1 <= s.length <= 2000

s consists of only lower case alphabets and brackets

The string will be balanced




Solution :-


import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();
    System.out.println(reverseParentheses(s));
  }

  public static String reverseParentheses(String s) {
    // your code here
	  Stack<String> stack = new Stack<>();
	  StringBuilder current = new StringBuilder();

	  for(char c : s.toCharArray())
		  {
			  if(c == '(')
			  {
				  stack.push(current.toString());
				  current.setLength(0);
			  }
			  else if(c == ')')
			  {
				  current.reverse();
				  String previous = stack.pop();
				  current.insert(0,previous);
			  }
			  else 
			  {
				  current.append(c);
			  }
		  }
	  return current.toString();
  }
}