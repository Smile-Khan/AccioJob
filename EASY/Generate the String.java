QUESTION :-  GENERATE THE STRING 

Your are given two strings a and b. Your task is to generate a new string containing first character of a, first character of b, second character of a, second character of b, and so on.

Input Format
The First line contains the string a

The Second line contains the string b

Output Format
Returns a single string required as per given problem

Example 1
Input

take
care
Output

tcaakree
Explanation

Here, on adding each character of string a and b, we get tcaakree

Example 2
Input

hello
world
Output

hweolrllod
Explanation

Here, on adding each character of string a and b, we get hweolrllod

Constraints
1 <= a.length <= 15

1 <= b.length <= 15

Both strings are of same length.


SOLUTION :-


import java.util.Scanner;

class Solution {
    public static String mergeStrings(String a, String b) {
        //Write your code here
		StringBuilder result = new StringBuilder();
        int i = 0, j = 0;

        while (i < a.length() && j < b.length()) {
            // Append the current character from string a.
            result.append(a.charAt(i++));
            // Append the current character from string b.
            result.append(b.charAt(j++));
        }

        // Append the remaining characters from both strings, if any.
        result.append(a.substring(i));
        result.append(b.substring(j));

        return result.toString();
    }
}
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        String result = Solution.mergeStrings(a, b);
        System.out.println(result);
    }
}