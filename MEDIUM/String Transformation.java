QUESTION :- String Transformation {
    

    Given a string str of length N, you have to create a new string by performing the following operation:

Take the smallest character from the first K characters of str, remove it from str and append it to the new string.

You have to perform this operation until str is empty.

Note:

The input string will not contain any spaces.
Assume that all characters in `str` are lower case letters.
If characters less than `K` remain, then append them in a sorted way to the new string.
Note: You just need to complete getTransformedString() function. Input and output have been managed for you.

Input Format
The first line contains a string str and an integer K. Both of them are seperated by spaces.

Output Format
Print the new string after performing all the operations.

Example 1
Input

cbedf 2
Output

bcdef
Explanation

The smallest character of the string is ''b'', followed by ''c'', ''d'', ''e'', and ''f'' respectively. Hence the output string is "bcdef".
Example 2
Input

fedcb 4
Output

cbdef
Explanation

Let the new string to be formed is initially empty, newString = "".
The first set of 4 characters are, (''f'', ''e'', ''d'', ''c'')
Out of these 4 characters, the smallest one is ''c'' and hence we add it to the newString and it becomes, 
newString = "c"

The next set of 4 characters are, (''f'', ''e'', ''d'', ''b'')
Out of these 4 characters, the smallest one is ''b'' and hence we add it to the newString and it becomes, 
newString = "cb"

Now we are left with "fed" and since we can''t get a window of size 4, we sort them in the increasing order and append them to the newString.

Hence, newString thus formed will be "cbdef".

Constraints
1 <= `N == str.length()` <= 105.
`str` consists of lowercase letters.
1 <= `K` <= 105




}


SOLUTION :-

import java.util.Scanner; 
class Solution {
    public static String getTransformedString(String str, int k) {
        // Write your code here
         StringBuilder newString = new StringBuilder();
        
        while (!str.isEmpty()) {
            int windowSize = Math.min(k, str.length());
            String window = str.substring(0, windowSize);
            char smallestChar = window.charAt(0);
            int smallestCharIndex = 0;
            
            for (int i = 1; i < windowSize; i++) {
                if (window.charAt(i) < smallestChar) {
                    smallestChar = window.charAt(i);
                    smallestCharIndex = i;
                }
            }
            
            newString.append(smallestChar);
            str = window.substring(0, smallestCharIndex) + window.substring(smallestCharIndex + 1) + str.substring(windowSize);
        }
        
        return newString.toString();
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in) ; 

        String s = sc.next() ; 
        int k = sc.nextInt() ; 
        System.out.print(Solution.getTransformedString(s,k));
        
    }
}