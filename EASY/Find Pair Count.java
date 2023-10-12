QUESTION :- Find Pair Count 
    
We''ll say that a pair in a string is two instances of a char separated by a char. So AxA the A''s make a pair.

Pair''s can overlap, so AxAxA contains 3 pairs -- 2 for A and 1 for x. Recursively compute the number of pairs in the given string s.

Input Format
The first line contains the string s.

Output Format
Return the number of pairs.

Example 1
Input

axa
Output

1
Explanation

The pair is "axa".
Example 2
Input

axax
Output

2
Explanation

The pairs are "axa" and "xax".
Constraints
1 <= s.length <= 10^3


SOLUTION :-

import java.io.IOException;
import java.util.Scanner;

class Solution {
    public int countPairs(String s) {
        //write code here
		int count = 0;

		for(int i = 0; i < s.length()-2; i++)
			{
				char firstChar = s.charAt(i);
				char secondChar = s.charAt(i+2);

				if(firstChar == secondChar)
				{
					count++;
				}
				
			}
		return count;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Solution obj = new Solution();
        System.out.println(obj.countPairs(s));
        sc.close();
    }
}
