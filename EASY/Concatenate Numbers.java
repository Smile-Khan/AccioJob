QUESTION :- Concatenate Numbers {
    

    
    Given two positive integers a and b, print the number after concatenating b at end of a. (a = 10 and b = 31 gives 1031)

Input Format
First line contains an integer a.

Second line contains an integer b.

Output Format
Print integer after concatenating.

Example 1
Input

10 
3
Output

103
Explanation

Number after concatenating

Example 2
Input

85 
50
Output

8550
Explanation

Number after concatenating

Constraints
1 <= a <= 10000
1 <= b <= 10000
}

SOLUTION :-


import java.util.Scanner;

class Solution {
    public static void concatenate(int a, int b) {
        // Write your code here
        String result = Integer.toString(a) + Integer.toString(b);
        System.out.print(result);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Solution obj= new Solution();
        obj.concatenate(a, b);
        
    }
}
